package com.iti.passwordvalidationapi.validators.password

import com.iti.passwordvalidationapi.validators.password.PasswordValidator

object MinimumSizeValidator {
  val DefaultMinimumPasswordLength = 9
}

case class MinimumSizeValidator (
  minimun: Int = MinimumSizeValidator.DefaultMinimumPasswordLength,
) extends PasswordValidator {

  def validate(password: String): Boolean = password.size >= minimun
}