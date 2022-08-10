package com.dungnd.mvvm.ui.bai11.product

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.dungnd.mvvm.R
import com.dungnd.mvvm.databinding.FragmentProductsBinding
import com.dungnd.mvvm.ui.base.BaseFragment
import com.dungnd.mvvm.ui.main.MainActivity

class ProductsFragment : BaseFragment<FragmentProductsBinding, ProductsViewModel>() {
    private val adapter= ProductAdapter()
    override fun layoutRes(): Int =R.layout.fragment_products

    override fun viewModelClass(): Class<ProductsViewModel> =ProductsViewModel::class.java

    override fun initView() {
        binding.rclV.adapter=adapter
        (activity as MainActivity).showLoading()
        viewModel.productList.observe(this){
            adapter.products=it.data
            adapter.notifyDataSetChanged()
            (activity as MainActivity).hiddenLoading()
        }

        adapter.onStudentClick={ product, _ ->
            findNavController().navigate(
                R.id.action_productsFragment_to_productDetailFragment,
                bundleOf(
                    Pair("image",product.images),
                Pair("name",product.name),
                Pair("description",product.description)
                )
            )
        }
    }
}