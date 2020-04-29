package com.iti.passwordvalidationapi.controllers

import akka.http.scaladsl.server.Directives._

import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport

trait BaseController extends FailFastCirceSupport {
  val healthRoute = path("health") { get { complete("ok") } }
}
