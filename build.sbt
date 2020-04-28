lazy val akkaHttpVersion  = "10.1.11"
lazy val akkaVersion      = "2.6.4"
lazy val circeVersion     = "0.12.3"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "com.iti",
      scalaVersion    := "2.13.1"
    )),
    name := "password-validation",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"                % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json"     % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-actor-typed"         % akkaVersion,
      "com.typesafe.akka" %% "akka-stream"              % akkaVersion,
      "ch.qos.logback"    % "logback-classic"           % "1.2.3",

      "com.typesafe.akka" %% "akka-http-testkit"        % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"                % "3.0.8"         % Test,

      "io.circe"          %% "circe-core"               % circeVersion,
      "io.circe"          %% "circe-generic"            % circeVersion,
      "io.circe"          %% "circe-parser"             % circeVersion,

      "de.heikoseeberger" %% "akka-http-circe"          % "1.31.0"
    )
  )

scalacOptions ++= Seq("-deprecation", "-feature")
