package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.Foods
import com.gorkemarslanbogan.techcareerbootcampbitirme.databinding.ProductCardBinding
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.fragment.HomeDirections
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel.HomeFragmentVieweModel

class HomePageAdapter(var context: Context, var item: List<Foods>, var viewModel: HomeFragmentVieweModel) : RecyclerView.Adapter<HomePageAdapter.ProductCard>() {

        inner class ProductCard(var binding: ProductCardBinding) : RecyclerView.ViewHolder(binding.root){

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCard {
            val binding: ProductCardBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.product_card,parent,false)
            return ProductCard(binding)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: ProductCard, position: Int) {
            val food = item[position]
            val v = holder.binding
            v.productName.text = food.yemek_adi
            v.productPrice.text = food.yemek_fiyat.plus(context.getString(R.string.turk_lirasi_sembol))
            viewModel.getFoodImages(v.productImage,food.yemek_resim_adi)

            v.addToCardButton.setOnClickListener {
                viewModel.addToCard(food,1, context)
            }

            v.productCard.setOnClickListener{
                val goToDetails = HomeDirections.goToDetails(food = food)
                Navigation.findNavController(it).navigate(goToDetails)
            }

        }

        override fun getItemCount(): Int {
               return item.size

        }

    }