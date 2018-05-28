package controllers.snapshot

import javax.inject._
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class SnapshotService @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def getSnapshots(userId : Int) = Action { implicit request: Request[AnyContent] =>
    Ok.sendFile(new java.io.File("D:\\Projects\\BabyBank\\babybank\\public\\images\\gtr.jpg"), inline = true)
      .withHeaders(CONTENT_TYPE -> "image/jpeg")
  }

  def postSnapshot(userId : Int) = Action { implicit request : Request[AnyContent] =>
      Ok("Hi")
  }
}
