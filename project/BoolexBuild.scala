import sbt._
import sbt.Keys._
import com.typesafe.sbt.pgp.PgpKeys._

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
      homepage      := Some(url("https://github.com/mdread/boolex")),
      description   := "Boolean goodies for Scala",
      licenses      := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")),

      libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.6.4" % "test"),
      scalacOptions in Test ++= Seq("-Yrangepos"),

      // deployment settings
      useGpg := true,
      publishMavenStyle := true,
      publishTo := {
        val nexus = "https://oss.sonatype.org/"
        if (isSnapshot.value)
          Some("snapshots" at nexus + "content/repositories/snapshots")
        else
          Some("releases"  at nexus + "service/local/staging/deploy/maven2")
      },
      publishArtifact in Test := false,
      pomIncludeRepository := { _ => false },
      pomExtra := (
        <scm>
          <url>git@github.com:mdread/boolex.git</url>
          <connection>scm:git:git@github.com:mdread/boolex.git</connection>
        </scm>
        <developers>
          <developer>
            <id>mdread</id>
            <name>Daniel Camarda</name>
            <url>https://github.com/mdread</url>
          </developer>
        </developers>)

    )
  )
}
