/*
 * Solution to Project Euler problem #6: Sum Square Difference
 *
 * Created by Brandon Morris on April 26, 2016
 */

object Application {
  def main(args: Array[String]): Unit = {
    println(findDiff(100))
  }

  def findDiff(x: Int): Int = {
    squareOfSum(x) - sumOfSquares(x)
  }

  def squareOfSum(x: Int): Int = {
    val sum = (x * (x + 1)) / 2
    sum * sum
  }

  def sumOfSquares(x: Int): Int = {
    @scala.annotation.tailrec
    def sumOfSquares(x: Int, count: Int): Int = {
      if (x == 0) count
      else sumOfSquares(x - 1, count + (x * x))
    }
    sumOfSquares(x, 0)
  }
}
