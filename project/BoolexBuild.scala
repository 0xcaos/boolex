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
      crossScalaVersions := Seq("2.10.5", "2.11.7")
    )
  )
}
