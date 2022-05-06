package alchemy

import scala.util.Random

class Product {

  def getRandomProduct(): Tuple4[String, String, Float, Int] = {

    val random = new Random
    val product = productList(random.nextInt(productList.length))

    return product

  }
  var productList = Vector[Tuple4[String, String, Float, Int]](
    Tuple4("Accessories","Headphones",100.00f,101),
    Tuple4("Accessories","Mouse",100.00f,102),
    Tuple4("Accessories","Keyboard",100.00f,103),
    Tuple4("Computer","Desktop",1000.00f,104),
    Tuple4("Computer","Laptop",1000.00f,105),
    Tuple4("Home & Office","Chair",150.00f,106),
    Tuple4("Home & Office","Desk",150.00f,107),
    Tuple4("Mobile Device","Tablet",450.00f,108),
    Tuple4("Mobile Device","Cell Phone",450.00f,109)
  )

}
