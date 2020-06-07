package farm

import org.specs2._
import org.specs2.mutable.Specification

class FarmSpec extends Specification {
  "Farm" should {
    val farm = new Farm("Jenny's Farm")
    val chicken = Animal("Bob", 12, Chicken)
    val cow = Animal("Steak1", 3, Cow)
    val horse = Animal("Horsie", 5, Horse)
    val dog = Animal("Lulu", 6, Dog)

    "get the right tasks for a chicken" in {
      farm.tasksForTheDay(Seq(chicken)) must_== Seq(FarmTask(chicken, "checking for eggs"))
    }

    "get the right tasks for a cow" in {
      farm.tasksForTheDay(Seq(cow)) must_== Seq(FarmTask(cow, "milking"))
    }

    "get the right tasks for a cow and a horse" in {
      farm.tasksForTheDay(Seq(cow, horse)) must have size(2)
      farm.tasksForTheDay(Seq(cow, horse)) must_== Seq(FarmTask(cow, "milking"), FarmTask(horse, "plowing"))
      farm.tasksForTheDay(Seq(cow, horse)) must beLike {
        case Seq(FarmTask(_, cowTask), FarmTask(_, horseTask)) =>
          cowTask must_== "milking"
          horseTask must_== "plowing"
      }
    }

    "get no task for dog" in {
      farm.tasksForTheDay(Seq(dog)) must beEmpty
    }
  }
}