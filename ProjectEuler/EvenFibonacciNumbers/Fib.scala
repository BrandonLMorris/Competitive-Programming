object Application {
  def main(args: Array[String]): Unit = {

    @scala.annotation.tailrec
    def sum_even_fibs(current: Int, x: Int, y: Int): Int = {
      if (y > 4000000) current
      else if (y % 2 == 0) sum_even_fibs(current + y, y, x + y)
      else sum_even_fibs(current, y, x + y)
    }


    println(sum_even_fibs(0, 1, 2))
  }
}
