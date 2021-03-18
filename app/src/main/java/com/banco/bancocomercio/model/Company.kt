package com.banco.bancocomercio.model

import com.google.gson.annotations.SerializedName

class Company {
    @field:SerializedName("name")
    val name: String? = null

    @field:SerializedName("catchPhrase")
    val catchPhrase: String? = null

    @field:SerializedName("bs")
    val bs: String? = null
}