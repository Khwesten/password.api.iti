package com.iti.validators.password

import org.scalatest.WordSpec
import com.iti.passwordvalidationapi.validators.password.MinimumSizeValidator

class MinimumSizeValidatorSpec extends WordSpec with SharedEmptyValidatorBehaviors {
  val lowerCaseDescription = "special character"
  val validator = MinimumSizeValidator()

  "return true" when {
    "bigger than default value(9)" in {
      assert(validator.validate("1234567890"))
    }

    "bigger than custom value(15)" in {
      val customValidator = MinimumSizeValidator(15)

      assert(customValidator.validate("12345678901112131415"))
    }
  }

  "return false" when {
    behave like isEmpty(validator)

    "lower than default value(9)" in {
      assert(!validator.validate("12345678"))
    }

    "lower than custom value(15)" in {
      val customValidator = MinimumSizeValidator(15)

      assert(!customValidator.validate("1234567890"))
    }
  }
}
