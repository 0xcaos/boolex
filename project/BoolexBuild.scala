import sbt._
import sbt.Keys._

object BoolexBuild extends Build {

  lazy val boolex = Project(
    id = "boolex",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "boolex",
      organization := "net.caoticode.boolex",
      version := "1.0.0",
      scalaVersion := "2.11.7",
      crossScalaVersions := Seq("2.10.5", "2.11.7"),

      libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.6.4" % "test"),
      scalacOptions in Test ++= Seq("-Yrangepos")
    )
  )
}
