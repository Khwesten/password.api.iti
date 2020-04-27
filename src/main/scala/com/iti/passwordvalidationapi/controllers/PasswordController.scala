package com.iti.passwordvalidationapi.controllers

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

class PasswordController extends BaseController {

  private def validation = post {
    complete("OK!")
  }

  val passwordRoutes = pathPrefix("passwords") {
    validation
  }
}