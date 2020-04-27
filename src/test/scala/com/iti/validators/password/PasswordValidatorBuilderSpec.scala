package com.iti.validators.password

import org.scalatest.WordSpec
import com.iti.passwordvalidationapi.validators.password.PasswordValidatorBuilder
import com.iti.passwordvalidationapi.validators.password.MinimumSizeValidator
import com.iti.passwordvalidationapi.validators.password.AtLeastOneDigitValidator
import com.iti.passwordvalidationapi.validators.password.AtLeastOneLowerCaseValidator
import com.iti.passwordvalidationapi.validators.password.AtLeastOneUpperCaseValidator
import com.iti.passwordvalidationapi.validators.password.AtLeastOneSpecialCharacterValidator

class PasswordValidatorBuilderSpec extends WordSpec {
  "isValid" when {
    "hasn't validators" in {
      val passwordValidatorBuilder = new PasswordValidatorBuilder()

      assert(passwordValidatorBuilder.isValid("1"))
    }

    "has more than default value(9) to minimumSizeValidator" in {
      val passwordValidatorBuilder = new PasswordValidatorBuilder(MinimumSizeValidator())

      assert(passwordValidatorBuilder.isValid("1234567890"))
    }

    "has all validators and clausules attended" in {
      val passwordValidatorBuilder = new PasswordValidatorBuilder(
        MinimumSizeValidator(),
        AtLeastOneDigitValidator(),
        AtLeastOneLowerCaseValidator(),
        AtLeastOneUpperCaseValidator(),
        AtLeastOneSpecialCharacterValidator()
      )

      assert(passwordValidatorBuilder.isValid("qwe123!@#QWE"))
    }
  }

  "isInvalid" when {
    "has less than default value(9) to minimumSizeValidator" in {
      val passwordValidatorBuilder = new PasswordValidatorBuilder(MinimumSizeValidator())

      assert(!passwordValidatorBuilder.isValid("12345678"))
    }

    "has all validators and clausules not attended at all" in {
      val passwordValidatorBuilder = new PasswordValidatorBuilder(
        MinimumSizeValidator(),
        AtLeastOneDigitValidator(),
        AtLeastOneLowerCaseValidator(),
        AtLeastOneUpperCaseValidator(),
        AtLeastOneSpecialCharacterValidator()
      )

      assert(!passwordValidatorBuilder.isValid("qwe123!@#"))
    }
  }
}