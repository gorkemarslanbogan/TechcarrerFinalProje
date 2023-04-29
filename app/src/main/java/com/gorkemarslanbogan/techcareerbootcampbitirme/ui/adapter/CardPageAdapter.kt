package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.CardFood
import com.gorkemarslanbogan.techcareerbootcampbitirme.databinding.BagCardBinding
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel.CardFragmentViewModel

class CardPageAdapter(var context: Context, private var item: List<CardFood>, var viewModel: CardFragmentViewModel) : RecyclerView.Adapter<CardPageAdapter.BasketCard>() {

        inner class BasketCard(var binding: BagCardBinding) : RecyclerView.ViewHolder(binding.root){

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketCard {
            val binding: BagCardBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.bag_card,parent,false)
            return BasketCard(binding)
        }


        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: BasketCard, position: Int) {
            val food = item[position]
            val v = holder.binding
            val total = food.yemek_siparis_adet * food.yemek_fiyat
           v.detailsDescTittle.text = "Ürün Adı: ${food.yemek_adi}"
            "Birim fiyat: ${food.yemek_siparis_adet.toString()}"
           v.detailsDescPrice.text = "Birim fiyat: ${food.yemek_fiyat.toString()}"
           v.bagProductStock1.text =  "x ${food.yemek_siparis_adet.toString()}"
           v.detailsDescTotalprice.text = " Toplam: ${context.getString(R.string.turk_lirasi_sembol) +" " +total.toString()}"
            viewModel.getFoodImages(v.imageView3, food.yemek_resim_adi)
            v.removeButton.setOnClickListener {
                viewModel.removeCard(food.sepet_yemek_id)
            }

        }

        override fun getItemCount(): Int {
            return item.size
        }
    }