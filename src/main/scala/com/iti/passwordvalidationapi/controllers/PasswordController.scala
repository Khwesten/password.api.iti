package com.iti.passwordvalidationapi.controllers

import com.iti.passwordvalidationapi.contracts.PasswordContract
import com.iti.passwordvalidationapi.validators.password.DefaultPasswordValidatorBuilder

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.auto._

class PasswordController extends BaseController {

  private def validatePassword = path("validatePassword") {
    post {
      entity(as[PasswordContract]) { contract =>
        validate(contract.validate, contract.errorMessage) {
          val validatorBuilder = DefaultPasswordValidatorBuilder.build()

          complete(validatorBuilder.isValid(contract.password))
        }
      }
    }
  }

  val passwordRoutes = validatePassword
}