package com.iti.passwordvalidationapi.controllers

import org.scalatest.{ Matchers, WordSpec }
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server._
import Directives._
import akka.http.scaladsl.model.ContentTypes

import io.circe.generic.auto._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport

class PasswordControllerSpec
  extends WordSpec
  with Matchers
  with ScalatestRouteTest
  with FailFastCirceSupport {

  val passwordController = new PasswordController()
  val passwordRoutesTest = passwordController.passwordRoutes
  val messageRejection = "We need a JSON like: { 'password': 'value' }"

  "POST validatePassword" when {
    "password attended all validators" should {
      "return true" in {

        val payloadJson = """{ "password": "qwe123!@#QWE" }"""

        Post("/validatePassword")
          .withEntity(ContentTypes.`application/json`, payloadJson) ~> passwordRoutesTest ~> check {
          responseAs[Boolean] shouldEqual true
        }
      }
    }

    "password attended one validator" should {
      "return false" in {

        val payloadJson = """{ "password": "qwe" }"""

        Post("/validatePassword")
          .withEntity(ContentTypes.`application/json`, payloadJson) ~> passwordRoutesTest ~> check {
          responseAs[Boolean] shouldEqual false
        }
      }
    }

    "password is empty" should {
      "return false" in {

        val payloadJson = """{ "password": "" }"""

        Post("/validatePassword")
          .withEntity(ContentTypes.`application/json`, payloadJson) ~> passwordRoutesTest ~> check {
          responseAs[Boolean] shouldEqual false
        }
      }
    }

    "body is empty" should {
      "return rejection msg" in {

        val payloadJson = ""

        Post("/validatePassword")
          .withEntity(ContentTypes.`application/json`, payloadJson) ~> passwordRoutesTest ~> check {
          responseAs[String] shouldEqual messageRejection
        }
      }
    }

    "body is an empty json" should {
      "return rejection msg" in {

        val payloadJson = "{}"

        Post("/validatePassword")
          .withEntity(ContentTypes.`application/json`, payloadJson) ~> passwordRoutesTest ~> check {

          responseAs[String] shouldEqual messageRejection
        }
      }
    }
  }
}