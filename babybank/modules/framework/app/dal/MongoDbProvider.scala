package dal

import javax.inject._
import org.mongodb.scala._
import com.typesafe.config.ConfigFactory

@Singleton
class MongoDbProvider() {

  private lazy val client : MongoClient = MongoClient()

  def getMongoDBProvider()={

    ConfigFactory.load.getString("your.key")
  }



}
