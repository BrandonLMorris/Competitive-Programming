object Application {
  val Q_VAL = BigInt("600851475143")
  val Q_VAL_DOUBLE = Q_VAL.toDouble
  val Q_LONG = Q_VAL.toLong

  def main(args: Array[String]): Unit = {
    println(largestPrimeFactor(Q_LONG))
  }

  def largestPrimeFactor(x: Long): Int = {
    @scala.annotation.tailrec
    def innerLargestPrimeFactor(x: Long, curr: Int, largest: Int): Int = {
      if (x == 1) largest
      else if (x % curr == 0) innerLargestPrimeFactor(x / curr, curr, curr)
      else innerLargestPrimeFactor(x, curr + 2, largest)
    }

    if (x % 2 == 0) largestPrimeFactor(x / 2L)
    else innerLargestPrimeFactor(x, 3, 1)
  }
}

