package com.iti.passwordvalidationapi.validators.password

import com.iti.passwordvalidationapi.validators.password.PasswordValidator

case class AtLeastOneLowerCaseValidator() extends PasswordValidator {

  def validate(password: String): Boolean =
    password.collectFirst { case char if char.isLower => char }.isDefined
}