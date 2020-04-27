package com.iti.passwordvalidationapi.validators.password

trait PasswordValidator {
  def validate(password: String): Boolean
}
