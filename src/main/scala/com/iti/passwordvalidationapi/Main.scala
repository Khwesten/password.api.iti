package com.iti.passwordvalidationapi

import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import com.iti.passwordvalidationapi.Routes

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.Failure
import scala.util.Success
import scala.concurrent.Future
import akka.actor.Terminated

object Main extends App with Routes {

  import com.iti.passwordvalidationapi.utils.AkkaExecutor.Global._

  val futureBinding = Http().bindAndHandleAsync(Route.asyncHandler(routes), "0.0.0.0", 9000)

  futureBinding.onComplete {
    case Success(binding) =>
      val address = binding.localAddress

      system.log.info("Server online at http://{}:{}/", address.getHostString, address.getPort)
    case Failure(ex) =>
      system.log.error("Failed to bind HTTP endpoint, terminating system", ex)
      system.terminate()
  }

  sys.addShutdownHook {
    val onceAllConnectionsTerminated =
      Await.result(futureBinding, 10.seconds).terminate(hardDeadline = 3.seconds)

    onceAllConnectionsTerminated.flatMap(_ => system.terminate())
  }
}
