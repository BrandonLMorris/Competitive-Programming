object Application {
  def main(args: Array[String]) = {
    val x = for (i <- 100 to 1000;
                 j <- i to 1000
                 if isPalindrome(i * j)) yield i * j
    println(x.reduceLeft(math.max(_, _)))

  }

  def isPalindrome(x: Int): Boolean = {
    x.toString.reverse == x.toString
  }
}
