package tools.errorManagement

import play.api.http.Status

case class ServiceException(errorMessage : String, status: Status) extends Throwable