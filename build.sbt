name := "Termo"

version := "1.0"

scalaVersion := "2.13.6"

Compile / scalaSource := baseDirectory.value / "src" / "main" / "Termo"


libraryDependencies += "com.typesafe.play" % "play-json_2.11" % "2.7.4"