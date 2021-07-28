package models

data class Magazine (
    override val id: Int,
    override var title: String,
    override var author: String,
    override var genre: String,
    override var price: Double,
    override var stock: Int,
    override var favorite: Boolean=false,
    override var discount: Int=0,
    private var Month:String,
    private var Year:Int
):Product(){
    init {
        countMagazine++
    }
    fun getMonth():String{
        return Month
    }
    fun setMonth(Month: String){
        this.Month=Month
    }
    fun getYear():Int{
        return Year
    }
    fun setYear(Year: Int){
        this.Year=Year
    }
}
