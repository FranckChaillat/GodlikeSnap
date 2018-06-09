package dal

import com.typesafe.config.ConfigFactory
import javax.inject.Singleton
import javax.inject._
import play.api.Configuration

trait Database{
  val connectionString : String
  def loadCredentials : String
}

@Singleton
case class Snapshot @Inject() (conf : Configuration) extends Database{
  lazy val connectionString = loadCredentials

  override def loadCredentials: String = {
    val login = ConfigFactory.load.getString("database.snapshot.credentials.login")
    val pw = ConfigFactory.load.getString("database.snapshot.credentials.password")
    s"mongodb+srv://$login:$pw@cluster0-hu24o.mongodb.net/test?retryWrites=true"
  }
}

