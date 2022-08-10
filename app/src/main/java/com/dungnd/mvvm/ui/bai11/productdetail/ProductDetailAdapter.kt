package com.dungnd.mvvm.ui.bai11.productdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dungnd.mvvm.data.local.model.Images
import com.dungnd.mvvm.data.local.model.Products
import com.dungnd.mvvm.databinding.ItemProductsBinding
import com.dungnd.mvvm.ui.bai11.product.ProductAdapter
import com.dungnd.mvvm.util.setOnSingClickListener

class ProductDetailAdapter: RecyclerView.Adapter<ProductDetailAdapter.ProductDetailViewHolder>() {
    inner class ProductDetailViewHolder
    constructor(private val binding: ItemProductsBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(images: Images){
            binding.nameItem.text=images.title
            binding.descriptionItem.text=images.description
            Glide.with(itemView.context).load(images.url.toString()).into(binding.ivImage)

        }

    }
    var images:List<Images>?=null
//    var onStudentClick:((Images, Int)->Unit)?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailViewHolder {
        val binding= ItemProductsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductDetailViewHolder, position: Int) {
        images?.get(position)?.let { holder.bind(it) }

    }

    override fun getItemCount(): Int {
        return images?.size ?:0
    }
}