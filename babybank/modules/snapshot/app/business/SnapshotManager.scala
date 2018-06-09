package business

import java.util.Date

import play.api.http.Status
import tools.errorManagement.ApiResult

object SnapshotManager {

  def getSnapshots(offset : Option[Int], limit : Int) ={

    if(limit > 10 || limit < 0)
      ApiResult.failure[String](500, None)
    else
      ApiResult.success("Hello world", 200)
  }

  def getSnapshots(startDate : Date, endDate : Date) = {
  }
}
