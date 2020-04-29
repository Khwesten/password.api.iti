package com.iti.passwordvalidationapi.controllers

import com.iti.passwordvalidationapi.contracts.PasswordContract
import com.iti.passwordvalidationapi.validators.password.DefaultPasswordValidatorBuilder

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import io.circe.generic.auto._
import com.iti.passwordvalidationapi.controllers.rejections.PasswordRejectionHandler

class PasswordController extends BaseController {

  private def validatePassword = path("validatePassword") {
    post {
      entity(as[PasswordContract]) { contract =>
        val validatorBuilder = DefaultPasswordValidatorBuilder.build()

        complete(validatorBuilder.isValid(contract.password))
      }
    }
  }

  val passwordRoutes = handleRejections(PasswordRejectionHandler.handle) {
    validatePassword
  }
}