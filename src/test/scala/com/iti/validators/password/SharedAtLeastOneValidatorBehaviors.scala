package com.iti.validators.password

import org.scalatest.WordSpec
import com.iti.passwordvalidationapi.validators.password.PasswordValidator
import com.iti.validators.password.SharedEmptyValidatorBehaviors

trait SharedAtLeastOneValidatorBehaviors extends SharedEmptyValidatorBehaviors { this: WordSpec =>
  val hasAtLeastOnePassword = "a1Q!"
  val hasMoreThanOnePassword = "abc123QWE!@#"

  def hasAtLeastOne(descriptionValue: String, validator: PasswordValidator) {
    s"has at least one ${descriptionValue}" in {
      assert(validator.validate(hasAtLeastOnePassword))
    }
  }

  def hasOnly(descriptionValue: String, password: String, validator: PasswordValidator) {
    s"has only ${descriptionValue}" in {
      assert(validator.validate(password))
    }
  }

  def hasMoreThanOne(descriptionValue: String, validator: PasswordValidator) {
    s"has more than one ${descriptionValue}" in {
      assert(validator.validate(hasMoreThanOnePassword))
    }
  }

  def hasNotExpected(descriptionValue: String, password: String, validator: PasswordValidator) {
    s"password hasn't ${descriptionValue} chars" in {
      assert(!validator.validate(password))
    }
  }
}