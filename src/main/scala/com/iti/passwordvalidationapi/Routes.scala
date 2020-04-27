package com.iti.passwordvalidationapi

import com.iti.passwordvalidationapi.controllers.PasswordController
import com.iti.passwordvalidationapi.controllers.BaseController

trait Routes extends BaseController {

  val passwordRoutes = new PasswordController().passwordRoutes

  val routes = passwordRoutes
}
