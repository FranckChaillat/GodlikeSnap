package controllers.snapshot

import business.SnapshotManager
import javax.inject._
import play.api.mvc._
import tools.errorManagement.{ErrorHandler}

import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class SnapshotService @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def getSnapshots(userId : Int) = Action { implicit request: Request[AnyContent] =>
    Ok.sendFile(new java.io.File("D:\\Projects\\BabyBank\\babybank\\public\\images\\gtr.jpg"), inline = true)
      .withHeaders(CONTENT_TYPE -> "image/jpeg")
  }

  def postSnapshot(userId : Int) = Action { implicit request : Request[AnyContent] =>
    val ah = ErrorHandler.excecute((_) => {
      SnapshotManager.getSnapshots(Some(0), 10)
    })
    new Status(ah.status)(ah.value.get)
  }
}
