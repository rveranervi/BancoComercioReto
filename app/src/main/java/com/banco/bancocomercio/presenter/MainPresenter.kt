package com.banco.bancocomercio.presenter

import com.banco.bancocomercio.contract.MainContract
import com.banco.bancocomercio.model.User
import com.banco.bancocomercio.model.serviceImp.APIRetoImp

class MainPresenter(_view: MainContract.View): MainContract.Presenter {

    private var view: MainContract.View = _view
    private var model: MainContract.Model = APIRetoImp()

    init {
        view.initView()
    }

    override fun callUsers() {
        model.getUsers(this)
    }

    override fun uiAutoUpdate(body: List<User>?) {
        view.updateViewData(body)
    }

    override fun showUser(position: Int) {
        model.getUser(this, position)
    }

    override fun uiPopUpUpdate(usuario: User?) {
        view.updateViewDataUser(usuario)
    }

}