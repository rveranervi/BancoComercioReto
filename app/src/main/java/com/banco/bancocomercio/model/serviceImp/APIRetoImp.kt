package com.banco.bancocomercio.model.serviceImp

import android.util.Log
import com.banco.bancocomercio.contract.MainContract
import com.banco.bancocomercio.model.User
import com.banco.bancocomercio.model.service.APIReto
import com.banco.bancocomercio.model.service.APIServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APIRetoImp: MainContract.Model {
    private var apiclient: APIServices? = null
    private var results: List<User>? = null

    init {
        apiclient = APIReto.client.create(APIServices::class.java)
    }
    override fun getUsers(presenter: MainContract.Presenter) {
        Log.d("presenter", "Abrio el presenter")
        val call = apiclient?.getUsers()
        call?.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                Log.d("failure", t.toString())
            }

            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
                if (response?.isSuccessful!!) {
                    results = response?.body()
                    presenter.uiAutoUpdate(results)
                }
            }
        })
    }

    override fun getUser(presenter: MainContract.Presenter, position: Int) {
        presenter.uiPopUpUpdate(results?.get(position))
    }
}