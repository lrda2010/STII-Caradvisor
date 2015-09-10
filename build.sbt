name := "tesiscolfer"

version := "1.0"

lazy val `tesiscolfer` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( javaJdbc , javaEbean , cache , javaWs )

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.6"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  