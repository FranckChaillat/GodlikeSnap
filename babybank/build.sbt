name := """babybank"""
organization := "com.bbbank"

version := "1.0-SNAPSHOT"

routesGenerator := InjectedRoutesGenerator

lazy val root = (project in file("."))
                  .enablePlugins(PlayScala)
                  .dependsOn(framework, snapshot)
                  .aggregate(snapshot, framework)



lazy val framework = (project in file("/modules/framework"))
                        .enablePlugins(PlayScala)
  .settings(libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.3.0")

lazy val snapshot = (project in file("/modules/snapshot"))
                        .enablePlugins(PlayScala)
                        .dependsOn(framework)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

//TwirlKeys.templateImports += "com.bbbank.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.bbbank.binders._"
