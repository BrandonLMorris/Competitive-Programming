/**
 * Solution to Project Euler problem # 9: Special Pythagorean Triplet
 *
 * Created by Brandon Morris on April 26, 2016
 */

object Application {
  def main(args: Array[String]) = {
    println(getTripletForSum(1000).reduceLeft(_ * _))
  }

  /**
   * Find the Pythagorean triplet (a^2 + b^2 = c^2) where the sum of the
   * triplet is equal to the argument
   *
   * @returns A list of integers, representing the numbers of the triplet (a,
   *          b, and c)
   */
  def getTripletForSum(x: Int): List[Int] = {
    val triples = for (i <- 1 to 1000;
                       j <- i to 1000 if isPerfectSquare((i * i) + (j * j)))
                       yield List(i, j, math.sqrt(i * i + j * j).toInt)
    triples.filter((l) => l(0) + l(1) + l(2) == 1000)(0)
  }

  /** Return true if argument is a perfect square */
  def isPerfectSquare(x: Int): Boolean = {
    val squareRoot = math.sqrt(x)
    squareRoot.toInt == squareRoot
  }
}
