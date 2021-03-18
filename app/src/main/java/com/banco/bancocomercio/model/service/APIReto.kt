package com.banco.bancocomercio.model.service

import com.banco.bancocomercio.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIReto {
    companion object {
        private var retrofit: Retrofit? = null
        val client: Retrofit
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(BuildConfig.BASEURL)
                            .build()
                }
                return retrofit!!
            }
    }
}