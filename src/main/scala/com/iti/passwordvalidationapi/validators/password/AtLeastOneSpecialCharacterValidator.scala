package com.iti.passwordvalidationapi.validators.password

import com.iti.passwordvalidationapi.validators.password.PasswordValidator

class AtLeastOneSpecialCharacterValidator extends PasswordValidator {
  val SpecialCharacterRegex = """\W|_""".r

  def validate(password: String): Boolean = password match {
    case p if SpecialCharacterRegex.findFirstMatchIn(p).isDefined => true
    case _ => false
  }
}