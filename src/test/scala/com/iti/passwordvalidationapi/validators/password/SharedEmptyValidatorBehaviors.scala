package com.iti.validators.password

import org.scalatest.WordSpec
import com.iti.passwordvalidationapi.validators.password.PasswordValidator

trait SharedEmptyValidatorBehaviors { this: org.scalatest.WordSpec =>
  def isEmpty(validator: PasswordValidator) = {
    "password is empty" in {
      assert(!validator.validate(""))
    }
  }
}