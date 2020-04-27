package com.iti.passwordvalidationapi.validators.password

import com.iti.passwordvalidationapi.validators.password.PasswordValidator

class PasswordValidatorBuilder(validators: PasswordValidator*) {

  def isValid(password: String): Boolean = {
    val isInvalid = validators
      .map(validator => validator.validate(password))
      .filter(!_)
      .size > 0

    !isInvalid
  }
}