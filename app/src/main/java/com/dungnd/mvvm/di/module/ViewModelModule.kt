package com.dungnd.mvvm.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dungnd.mvvm.di.viewmodel.ViewModelFactory
import com.dungnd.mvvm.di.viewmodel.ViewModelKey
import com.dungnd.mvvm.ui.bai11.product.ProductsViewModel
import com.dungnd.mvvm.ui.bai11.productdetail.ProductDetailViewModel
import com.dungnd.mvvm.ui.detail.DetailViewModel
import com.dungnd.mvvm.ui.home.HomeViewModel
import com.dungnd.mvvm.ui.main.MainViewModel
import com.dungnd.mvvm.ui.info.InfoViewModel
import com.dungnd.mvvm.ui.manager.StudentManagerViewModel
import com.dungnd.mvvm.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun splashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    internal abstract fun detailViewModel(viewModel: DetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StudentManagerViewModel::class)
    internal abstract fun studentManagerViewModel(viewModel: StudentManagerViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(InfoViewModel::class)
    internal abstract fun inforViewModel(viewModel: InfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    internal abstract fun productsViewModel(viewModel: ProductsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailViewModel::class)
    internal abstract fun productDetailViewModel(viewModel: ProductDetailViewModel): ViewModel
}