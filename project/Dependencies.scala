import sbt.Keys._
import sbt._

object Dependencies {

  object Version {
    lazy val janino = "3.1.0"
    lazy val logbackClassic = "1.2.3"
    lazy val newtype = "0.4.3"
    lazy val refined = "0.9.12"
    lazy val scalaCheckShapeless = "1.2.4"
    lazy val scalaLogging = "3.9.2"
    lazy val scalaTest = "3.1.0"
    lazy val scalafixSortImports = "0.3.2"
  }

  lazy val core: Seq[Setting[_]] = deps(
    "eu.timepit" %% "refined"                 % Version.refined,
    "io.estatico" %% "newtype" % Version.newtype
  )

  lazy val logging: Seq[Setting[_]] = deps(
    "ch.qos.logback" % "logback-classic" % Version.logbackClassic,
    "com.typesafe.scala-logging" %% "scala-logging" % Version.scalaLogging,
    "org.codehaus.janino" % "janino" % Version.janino
  )

  lazy val test: Seq[Setting[_]] = deps(
    "org.scalatest" %% "scalatest" % Version.scalaTest % Test,
    "com.github.alexarchambault" %% "scalacheck-shapeless_1.14" % Version.scalaCheckShapeless % Test
  )

  private def deps(modules: ModuleID*): Seq[Setting[_]] = Seq(libraryDependencies ++= modules)
}
