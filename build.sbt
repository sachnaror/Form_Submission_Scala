
name := "Scala Contact Form"

version := "0.1"

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  "org.xerial" % "sqlite-jdbc" % "3.36.0.3",
  "org.scalatra" %% "scalatra" % "2.7.0",
  "javax.servlet" % "javax.servlet-api" % "4.0.1" % "provided"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-encoding", "utf8"
)

testOptions in Test += Tests.Argument("-oD")

