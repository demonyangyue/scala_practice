import sbt._
import sbt.Keys._

object MsortsampleBuild extends Build {

  lazy val msortsample = Project(
    id = "msortsample",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "msortSample",
      organization := "org.example",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2"
      // add other settings here
    )
  )
}
