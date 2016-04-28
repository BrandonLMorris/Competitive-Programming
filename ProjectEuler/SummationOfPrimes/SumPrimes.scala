/**
 * Solution to Project Euler problem #10: Summation of Primes
 *
 * Created by Brandon Morris on April 27, 2016
 */

object Application {
  val TWO_MILLION = 2000000

  def main(args: Array[String]): Unit = {
    // Generate prime numbers the Scala way
    lazy val primeStream: Stream[Int] = 2 #:: Stream.from(3)
      .filter(i => primeStream.takeWhile{j => j * j <= i}
      .forall{k => i % k > 0})

    // Watch out for overflow!
    println(primeStream.takeWhile(i => i < TWO_MILLION).map(BigInt(_)).sum)
  }

}
