package models

data class Article(
    override val id: Int,
    override var title: String,
    override var author: String,
    override var genre: String,
    override var price: Double,
    override var stock: Int,
    override var favorite: Boolean=false,
    override var discount: Int=0,
    private var namePublication: String="",
    private var yearPublication: Int=0,
    private var monthPublication:String=""
):Product(){
    init {
        countArticle++
    }
    fun getNamePublication():String{
        return namePublication
    }
    fun setNamePublication(namePublication: String){
        this.namePublication=namePublication
    }
    fun getYearPublication():Int{
        return yearPublication
    }
    fun setYearPublication(yearPublication: Int){
        this.yearPublication=yearPublication
    }
    fun getMonthPublication():String{
        return monthPublication
    }
    fun setMonthPublication(monthPublication: String){
        this.monthPublication=monthPublication
    }

}