package com.banco.bancocomercio.view.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.banco.bancocomercio.R
import com.banco.bancocomercio.contract.MainContract
import com.banco.bancocomercio.model.User
import com.banco.bancocomercio.presenter.MainPresenter
import com.banco.bancocomercio.view.adapters.AdapterUsers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        initView()
    }

    override fun initView() {
        presenter?.callUsers()
    }

    override fun updateViewData(body: List<User>?) {
        rvUsers.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = AdapterUsers(body, this@MainActivity)
        }
    }

    override fun selectedUser(position: Int) {
        presenter?.showUser(position)
    }

    override fun updateViewDataUser(usuario: User?) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(usuario!!.name)
        builder.setMessage("Username: ${usuario!!.username}\n" +
                "Email: ${usuario!!.email}\n" +
                "Dirección: ${usuario!!.address!!.street} ${usuario!!.address!!.suite} ${usuario!!.address!!.city}\n" +
                "GEO: ${usuario!!.address!!.geo!!.lat}, ${usuario!!.address!!.geo!!.lng}\n" +
                "Telefono: ${usuario!!.phone}\n" +
                "Sitio web: ${usuario!!.website}\n" +
                "Compañia: ${usuario!!.company!!.name}\n")
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}