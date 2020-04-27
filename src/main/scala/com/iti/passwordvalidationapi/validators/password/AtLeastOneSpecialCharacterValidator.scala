package com.iti.passwordvalidationapi.validators.password

import com.iti.passwordvalidationapi.validators.password.PasswordValidator

case class AtLeastOneSpecialCharacterValidator() extends PasswordValidator {
  val SpecialCharacterRegex = """\W|_""".r

  def validate(password: String): Boolean =
    SpecialCharacterRegex.findFirstMatchIn(password).isDefined
}
