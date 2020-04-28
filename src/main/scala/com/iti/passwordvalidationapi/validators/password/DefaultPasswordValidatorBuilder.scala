package com.iti.passwordvalidationapi.validators.password

object DefaultPasswordValidatorBuilder {
  def build(): PasswordValidatorBuilder = {
    PasswordValidatorBuilder(
      MinimumSizeValidator(),
      AtLeastOneDigitValidator(),
      AtLeastOneLowerCaseValidator(),
      AtLeastOneUpperCaseValidator(),
      AtLeastOneSpecialCharacterValidator()
    )
  }
}