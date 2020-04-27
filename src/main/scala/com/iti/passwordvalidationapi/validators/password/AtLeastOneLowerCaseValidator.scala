package com.iti.passwordvalidationapi.validators.password

import com.iti.passwordvalidationapi.validators.password.PasswordValidator

class AtLeastOneLowerCaseValidator extends PasswordValidator {
  def validate(password: String): Boolean = {
    val maybeOneLower = password.collectFirst { case letter => letter.isLower }

    maybeOneLower match {
      case Some(v) => v
      case _ => false
    }
  }
}