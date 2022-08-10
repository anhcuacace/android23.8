package com.dungnd.mvvm.ui.bai11.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dungnd.mvvm.data.local.model.Product
import com.dungnd.mvvm.data.local.model.Products
import com.dungnd.mvvm.data.local.model.Student
import com.dungnd.mvvm.databinding.ItemProductsBinding
import com.dungnd.mvvm.databinding.ItemStudentBinding
import com.dungnd.mvvm.util.setOnSingClickListener
 class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder
        constructor(private val binding: ItemProductsBinding)
                :RecyclerView.ViewHolder(binding.root){

            fun bind(product: Product){
                binding.nameItem.text=product.name
                binding.descriptionItem.text=product.description
                Glide.with(itemView.context).load(product.img.toString()).into(binding.ivImage)

            }

        }
var products:List<Product>?=null
    var onStudentClick:((Product,Int)->Unit)?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding=ItemProductsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        products?.get(position)?.let { holder.bind(it) }
        holder.itemView.setOnSingClickListener {
            products?.get(position)?.let { it1 -> onStudentClick?.invoke(it1,position) }
        }

    }

    override fun getItemCount(): Int {
        return products?.size ?:0
    }
}
