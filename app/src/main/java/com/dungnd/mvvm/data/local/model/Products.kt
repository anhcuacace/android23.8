package com.dungnd.mvvm.data.local.model

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("status")
    val status:String?=null,
    @SerializedName("code")
    val code:Int?=null,
    @SerializedName("total")
    val total:Int?=null,
    @SerializedName("data")
    val data:List<Product>?=null
)
    data class Product (
        @SerializedName("id")
        val id:Int?=null,
        @SerializedName("name")
        val name:String?=null,
        @SerializedName("description")
        val description:String?=null,
        @SerializedName("image")
        val img:String?=null,
        @SerializedName("images")
        val images:List<Images>?=null,

    )


data class Images (
    @SerializedName("title")
    val title:String?=null,
    @SerializedName("description")
    val description:String?=null,
    @SerializedName("url")
    val url:String?=null
    )
