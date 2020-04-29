package com.iti.validators.password

import org.scalatest.WordSpec
import com.iti.passwordvalidationapi.validators.password.AtLeastOneSpecialCharacterValidator

class AtLeastOneSpecialCharacterValidatorSpec extends WordSpec with SharedAtLeastOneValidatorBehaviors {
  val lowerCaseDescription = "special character"
  val validator = AtLeastOneSpecialCharacterValidator()

  "return true" when {
    behave like hasAtLeastOne(lowerCaseDescription, validator)

    behave like hasOnly(lowerCaseDescription, "!@#", validator)

    behave like hasMoreThanOne(lowerCaseDescription, validator)
  }

  "return false" when {
    behave like isEmpty(validator)

    behave like hasNotExpected(lowerCaseDescription, "aB1", validator)
  }
}
