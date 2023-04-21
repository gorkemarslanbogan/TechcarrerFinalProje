package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.Food
import com.gorkemarslanbogan.techcareerbootcampbitirme.databinding.ProductCardBinding
import java.util.*

class HomePageAdapter(var context: Context ,var item: List<Food>) : RecyclerView.Adapter<HomePageAdapter.ProductCard>() {

    inner class ProductCard(var binding: ProductCardBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCard {
        val binding: ProductCardBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.product_card,parent,false)
        return ProductCard(binding)
    }

    override fun onBindViewHolder(holder: ProductCard, position: Int) {
       val food = item[position]
       val v = holder.binding
        v.productName.text = food.yemek_adi
        v.productPrice.text = food.yemek_fiyat.toString()
        Glide.with(v.productImage).load("").into(v.productImage)
        v.addToCardButton.setOnClickListener {
            Toast.makeText(context,"Sepete başarıyla eklendi", Toast.LENGTH_LONG).show()
        }

    }

    override fun getItemCount(): Int {
       return item.size
    }
}