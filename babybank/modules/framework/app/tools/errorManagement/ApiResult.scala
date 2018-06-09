package tools.errorManagement
import play.api.http.{Status, Writeable}

trait  ApiResult[T] {
  def value : Option[T]
  def status : Int

}

case class ApiSuccess[T] private (value : Some[T], status: Int)
  extends ApiResult[T]

case class ApiFailure[T] private(status: Int, ex : Option[ServiceException])
  extends ApiResult[T]{val value = None}

object  ApiResult{
    def success[T](value : T, status: Int): ApiSuccess[T] = {
      val intStatus = status.asInstanceOf[Int]
      if (!Status.isClientError(intStatus) && !Status.isServerError(intStatus))
        ApiSuccess(Some(value), status)
      else
        throw new IllegalArgumentException("Unable to create new ApiSuccess object with error status")
    }

  def failure[T](status : Int, ex : Option[ServiceException] = None) = {
    val intStatus = status.asInstanceOf[Int]
    if (Status.isServerError(intStatus) || Status.isClientError(intStatus))
      ApiFailure[T](status, ex)
    else
      throw new IllegalArgumentException("Unable to create new ApiFailure object with error status")
  }

  def unapply[T](arg: ApiSuccess[T]): Option[(T, Int)] = Some((arg.value.value, arg.status))
  def unapply[T](arg: ApiFailure[T]): Option[(Int)] =
    Some((arg.status))
}