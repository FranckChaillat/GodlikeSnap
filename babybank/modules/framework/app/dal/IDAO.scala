package dal

trait DbRunnable[Runner]{
  def ExecReader[T](r : Runner) : T
  def ExecWrite(r : Runner) : Int
}

object DbRunnable {
  def read[R](runner : R)(implicit  rn : DbRunnable[R]) = rn.ExecReader(runner)

  implicit val mongoRead : DbRunnable[MongoDbProvider] = {
    new DbRunnable[MongoDbProvider] {
      override def ExecReader[T](r: MongoDbProvider): T = ???

      override def ExecWrite(r: MongoDbProvider): Int = ???
    }
  }

}
