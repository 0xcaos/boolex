import sbt._
import sbt.Keys._

object BoolexBuild extends Build {

  lazy val boolex = Project(
    id = "boolex",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "boolex",
      organization := "net.caoticode.boolex",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.0"
      // add other settings here
    )
  )
}
