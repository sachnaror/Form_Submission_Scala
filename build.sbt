name := "Form_Submission_Scala"

version := "0.1"

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.12" % Test,
  "ch.qos.logback" % "logback-classic" % "1.2.11",
  "com.typesafe" % "config" % "1.4.1"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-encoding", "utf8"
)

testOptions in Test += Tests.Argument("-oD")
