package com.dungnd.mvvm.ui.bai11.productdetail

import com.dungnd.mvvm.R
import com.dungnd.mvvm.data.local.model.Images
import com.dungnd.mvvm.data.local.model.Product
import com.dungnd.mvvm.databinding.FragmentProductDetailBinding
import com.dungnd.mvvm.ui.base.BaseFragment

class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding, ProductDetailViewModel>() {
    private val adapter= ProductDetailAdapter()

    override fun layoutRes(): Int =R.layout.fragment_product_detail

    override fun viewModelClass(): Class<ProductDetailViewModel> =ProductDetailViewModel::class.java

    override fun initView() {


        adapter.images= arguments?.get("image") as List<Images>?
        binding.rclV.adapter=adapter
        binding.nameItem.text= arguments?.get("name").toString()
        binding.descriptionItem.text=arguments?.get("description").toString()
    }
}