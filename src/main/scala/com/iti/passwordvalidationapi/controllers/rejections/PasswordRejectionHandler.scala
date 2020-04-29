package com.iti.passwordvalidationapi.controllers.rejections

import akka.http.scaladsl.server.RejectionHandler
import akka.http.scaladsl.server.RequestEntityExpectedRejection
import akka.http.scaladsl.server.MalformedRequestContentRejection
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._

import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._

object PasswordRejectionHandler {

  val defaultMessageRejection = "We need a JSON like: { 'password': 'value' }"

  def handle() =
    RejectionHandler.newBuilder()
      .handle {
        case RequestEntityExpectedRejection =>
          complete((BadRequest, defaultMessageRejection))
      }
      .handle {
        case MalformedRequestContentRejection(_, _) =>
          complete((BadRequest, defaultMessageRejection))
      }
      .result()
}
