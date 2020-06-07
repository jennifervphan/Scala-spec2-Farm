name := "Scala-AnimalFarm"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.8.3" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")
