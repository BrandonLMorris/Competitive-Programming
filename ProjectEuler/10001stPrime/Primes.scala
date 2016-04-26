/*
 * Solution fo Project Euler problem #6: 10,001st Prime
 *
 * Created by Brandon Morris April 26, 2016
 */
object Application {
  def main(args: Array[String]): Unit = {
    // Stream for generating prime numbers, taken from
    // https://stackoverflow.com/questions/15594227/calculating-prime-numbers-in-scala-how-does-this-code-work
    lazy val primeStream: Stream[Int] = 2 #:: Stream.from(3)
      .filter(i => primeStream.takeWhile{j => j * j <= i}
      .forall{k => i % k > 0})

    // Zero-based, so 10000 is the 10001st prime
    println(primeStream(10000))
  }
}
