package com.iti.passwordvalidationapi.validators.password

import com.iti.passwordvalidationapi.validators.password.PasswordValidator

class AtLeastOneUpperCaseValidator extends PasswordValidator {
  def validate(password: String): Boolean = {
    val maybeOneUpper = password.collectFirst { case letter => letter.isUpper }

    maybeOneUpper match {
      case Some(v) => v
      case _ => false
    }
  }
}