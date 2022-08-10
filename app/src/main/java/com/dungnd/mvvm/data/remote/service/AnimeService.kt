package com.dungnd.mvvm.data.remote.service

import com.dungnd.mvvm.data.local.model.Products
import com.dungnd.mvvm.data.remote.model.Photo
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface AnimeService {

    @GET("photos")
    suspend fun getAllPhoto(): List<Photo>
    @GET
    suspend fun getAllProducts(
        @Url url: String,
        @Query("_quantity") quantity: Int,
        @Query("_locale") locale: String,
        @Query("_taxes") taxes: Int,
        @Query("_categories_type") category: String
    ): Products

}