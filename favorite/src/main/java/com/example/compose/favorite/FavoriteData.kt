package com.example.compose.favorite

import com.example.compose.detial.InitialDetailData

data class FavoriteData(val title:String, val content:String, val favoriteNote:String)
fun FavoriteData.mapToDetail() = InitialDetailData(this.title,this.content)
