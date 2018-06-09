package tools.errorManagement

import play.api.http.Status

object ErrorHandler {
  def excecute[T] (function : (Unit => ApiResult[T])) : ApiResult[T] = {
    try
      function()
    catch{
      case ex @ ServiceException(_, s) => ApiResult.failure[T](s.asInstanceOf[Int], Some(ex))
      case _ => ApiResult.failure(500, None)
    }
  }

  object Throwable {
    def unapply(throwable: Throwable): Some[(String, Throwable)] =
      Some((throwable.getMessage(), throwable.getCause()))

  }
}
