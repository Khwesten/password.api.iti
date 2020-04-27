package com.iti.validators.password

import org.scalatest.WordSpec
import com.iti.passwordvalidationapi.validators.password.AtLeastOneUpperCaseValidator

class AtLeastOneUpperCaseValidatorSpec extends WordSpec with SharedAtLeastOneValidatorBehaviors {
  val lowerCaseDescription = "special character"
  val validator = AtLeastOneUpperCaseValidator()

  "return true" when {
    behave like hasAtLeastOne(lowerCaseDescription, validator)

    behave like hasOnly(lowerCaseDescription, "ABC", validator)

    behave like hasMoreThanOne(lowerCaseDescription, validator)
  }

  "return false" when {
    behave like isEmpty(validator)

    behave like hasNotExpected(lowerCaseDescription, "a!1", validator)
  }
}
