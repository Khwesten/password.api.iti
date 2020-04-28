package com.iti.passwordvalidationapi.contracts

case class PasswordContract(password: String) {
  def validate(): Boolean = password.nonEmpty
  def errorMessage(): String = s"Password cannot be empty."
}