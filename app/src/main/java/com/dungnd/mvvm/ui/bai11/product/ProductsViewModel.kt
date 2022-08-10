package com.dungnd.mvvm.ui.bai11.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dungnd.mvvm.data.local.model.Products
import com.dungnd.mvvm.data.remote.RemoteRepository
import com.dungnd.mvvm.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class  ProductsViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
): BaseViewModel() {
    var productList=MutableLiveData<Products>()
private fun getAllProducts(){
    viewModelScope.launch(Dispatchers.IO) {
        try {
            val data=remoteRepository.getAllProducts()
            productList.postValue(data)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}
    init {
        getAllProducts()
    }
}