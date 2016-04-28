/**
 * Solution to Project Euler problem #12: Highly Divisible Triangular Number
 *
 * Created by Brandon Morris on April 27, 2016
 */

object Application {
  def main(args: Array[String]): Unit = {
    println(smallestTriagWithNDivisors(501))
    // for (i <- 1 to 7) println(nthTriag(i) + ": " + numDivisors(nthTriag(i)))
  }

  def smallestTriagWithNDivisors(n: Int): Int = {
    @scala.annotation.tailrec
    def smallestTriagWithNDivisors(n: Int, curr: Int): Int = {
      println(nthTriag(curr))
      if (numDivisors(nthTriag(curr)) >= n) nthTriag(curr)
      else smallestTriagWithNDivisors(n, curr + 1)
    }

    smallestTriagWithNDivisors(n, 10000)
  }

  def nthTriag(n: Int): Int = {
    (n * (n + 1)) / 2
  }

  def numDivisors(x: Int): Int = {
    lazy val ps: Stream[Int] = 2 #:: Stream.from(3)
      .filter(i => ps.takeWhile{j => j * j <= i}
      .forall{k => i % k > 0})

    def something(x: Int, y: Int) = {
      def something(x: Int, y: Int, count: Int): Int = {
        if (x % y == 0) something(x / y, y, count + 1)
        else count
      }
      something(x, y, 0)
    }

    val z = ps.takeWhile{_ <= x / 2}.toList.map(j => something(x, j) + 1).filter(_ != 1)
    // println(z)
    if (z.length > 0) z.reduceLeft(_ * _)
    else 2  // Not true when x = 1, but mostly right
  }
}
