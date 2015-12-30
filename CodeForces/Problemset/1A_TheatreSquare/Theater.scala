import scala.io.StdIn

object Theater {
  def main(args: Array[String]) = {
    val tokens = StdIn.readLine().split(" ")
    val m = tokens(0).toLong
    val n = tokens(1).toLong
    val a = tokens(2).toDouble

    val result = Math.ceil(m/a) * Math.ceil(n/a)
    println(result.toLong)
  }
}
