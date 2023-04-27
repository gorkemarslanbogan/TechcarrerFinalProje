package com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity

/*class Basket {
    var items = ArrayList<Food>()
    companion object{
        fun getInit(): Basket {
            return Basket()
        }
    }

    fun addToCard(item: Food, stock: Int) : Boolean {
        var isHave = false
        if(stock>0){
            for (f in items) {
                if(f.yemek_id == item.yemek_id){
                    isHave = true
                }
            }
            if(isHave){
                item.stock += stock
            }else {
                item.stock += stock
                items.add(item)
            }
            isHave = false
            return true
        }
        return false
    }
    fun removeCard(id: Int) : Boolean {
        for (f in items) {
            if(f.yemek_id == id.toString()){
                items.remove(f)
                return true
            }
        }
        return false
    }

    fun getCardSize() : Int {
        return items.size
    }
}*/