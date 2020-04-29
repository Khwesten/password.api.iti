package com.iti.passwordvalidationapi.validators.password

import com.iti.passwordvalidationapi.validators.password.PasswordValidator

case class PasswordValidatorBuilder(validators: PasswordValidator*) {

  def isValid(password: String): Boolean = {
    validators.filter(validator => !validator.validate(password)).isEmpty
  }
}
