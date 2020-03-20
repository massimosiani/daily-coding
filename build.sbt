import Dependencies.Version
import sbt._

addCompilerPlugin(scalafixSemanticdb)
addCommandAlias("fix", "all compile:scalafix test:scalafix; scalafmtAll")

scalafixDependencies in ThisBuild += "com.nequissimus" %% "sort-imports" % Version.scalafixSortImports

lazy val dailyCoding = (project in file("."))
  .settings(Settings.core: _*)
