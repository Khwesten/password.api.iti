package com.iti.passwordvalidationapi.validators.password

import com.iti.passwordvalidationapi.validators.password.PasswordValidator

case class AtLeastOneDigitValidator() extends PasswordValidator {
  def validate(password: String): Boolean =
    password.collectFirst { case char if char.isDigit => char }.isDefined
}