package com.iti.validators.password

import org.scalatest.WordSpec
import com.iti.passwordvalidationapi.validators.password.AtLeastOneLowerCaseValidator

class AtLeastOneLowerCaseValidatorSpec extends WordSpec with SharedAtLeastOneValidatorBehaviors {
  val lowerCaseDescription = "lower case"
  val validator = AtLeastOneLowerCaseValidator()

  "return true" when {
    behave like hasAtLeastOne(lowerCaseDescription, validator)

    behave like hasOnly(lowerCaseDescription, "abc", validator)

    behave like hasMoreThanOne(lowerCaseDescription, validator)
  }

  "return false" when {
    behave like isEmpty(validator)

    behave like hasNotExpected(lowerCaseDescription, "1B#", validator)
  }
}
