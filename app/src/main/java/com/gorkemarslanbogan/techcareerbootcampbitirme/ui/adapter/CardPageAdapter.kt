package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.FoodModel
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.Foods
import com.gorkemarslanbogan.techcareerbootcampbitirme.databinding.ProductCardBinding

class CardPageAdapter(var context: Context, private var item: List<Foods>) : RecyclerView.Adapter<CardPageAdapter.BasketCard>() {

        inner class BasketCard(var binding: ProductCardBinding) : RecyclerView.ViewHolder(binding.root){

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketCard {
            val binding: ProductCardBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.product_card,parent,false)
            return BasketCard(binding)
        }

        override fun onBindViewHolder(holder: BasketCard, position: Int) {
//            val food = item[position]
//            val v = holder.binding


        }

        override fun getItemCount(): Int {
            return item.size
        }
    }