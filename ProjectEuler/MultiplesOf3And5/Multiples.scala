object Application {
  def main(args: Array[String]): Unit = {
    val ran = 15 to 1000

    val result = (1 to 1000).filter((x) => x % 5 == 0 || x % 3 == 0).sum
    println(result)
  }
}
