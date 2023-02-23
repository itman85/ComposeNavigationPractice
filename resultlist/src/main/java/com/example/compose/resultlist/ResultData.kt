package com.example.compose.resultlist

import com.example.compose.detial.InitialDetailData

data class ResultData(val title:String, val content:String)
fun ResultData.mapToDetail() = InitialDetailData(this.title,this.content)
