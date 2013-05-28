import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  def fromEnv(name: String) = System.getenv(name) match {
    case null => None
    case value => Some(value)
  }

  val appName = fromEnv("project.artifactId").getOrElse("atmosphere-play-chat")
  val appVersion = fromEnv("project.version").getOrElse("1.0.0-SNAPSHOT")

  val appDependencies = Seq(
    javaCore
    // Dependencies are managed by maven
    // "org.atmosphere" % "atmosphere-runtime" % "1.1.0.SNAPSHOT",
    // "org.atmosphere" % "atmosphere-play" % "1.0.0-SNAPSHOT"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings()

}
