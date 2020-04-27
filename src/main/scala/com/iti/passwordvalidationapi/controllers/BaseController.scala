package com.iti.passwordvalidationapi.controllers

import akka.http.scaladsl.server.Directives._

trait BaseController {
  val healthRoute = path("health") { get { complete("ok") } }
}
