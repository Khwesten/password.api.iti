package com.iti.validators.password

import org.scalatest.WordSpec
import com.iti.passwordvalidationapi.validators.password.AtLeastOneDigitValidator
import com.iti.passwordvalidationapi.validators.password.PasswordValidatorBuilder

class AtLeastOneDigitValidatorSpec extends WordSpec {
  val passwordValidatorBuilder = new PasswordValidatorBuilder(AtLeastOneDigitValidator())

  "return true" when {
    "has at least one digit" in {
      assert(passwordValidatorBuilder.isValid("a1"))
    }

    "has only digits" in {
      assert(passwordValidatorBuilder.isValid("123"))
    }

    "has more than one digit" in {
      assert(passwordValidatorBuilder.isValid("abc123"))
    }
  }

  "return false" when {
    "password is empty" in {
      assert(!passwordValidatorBuilder.isValid(""))
    }

    "password hasn't digits chars" in {
      assert(!passwordValidatorBuilder.isValid("aB#"))
    }
  }
}
