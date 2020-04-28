package com.iti.validators.password

import com.iti.passwordvalidationapi.validators.password.AtLeastOneDigitValidator
import org.scalatest.WordSpec

class AtLeastOneDigitValidatorSpec extends WordSpec with SharedAtLeastOneValidatorBehaviors {
  val lowerCaseDescription = "digit"
  val validator = AtLeastOneDigitValidator()

  "return true" when {
    behave like hasAtLeastOne(lowerCaseDescription, validator)

    behave like hasOnly(lowerCaseDescription, "123", validator)

    behave like hasMoreThanOne(lowerCaseDescription, validator)
  }

  "return false" when {
    behave like isEmpty(validator)

    behave like hasNotExpected(lowerCaseDescription, "aB#", validator)
  }
}
