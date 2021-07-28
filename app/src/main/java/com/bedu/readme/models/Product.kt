package models

abstract class Product {
    abstract val id:Int
    abstract var title:String
    abstract var author:String
    abstract var genre:String
    abstract var price:Double
    abstract var stock:Int
    abstract var favorite:Boolean
    abstract var discount:Int

    fun getPrice(id:Int):Double{
            return price-(price*discount)
        }


}