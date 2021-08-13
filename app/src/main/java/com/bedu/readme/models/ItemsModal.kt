package com.bedu.readme.models

data class ItemsModal(
    val id: Int,
    var title: String,
    var author: String,
    var genre: String,
    var price: Double,
    var image: String = "",
    var typeLiteraure: String,
)