package com.banco.bancocomercio.contract

import com.banco.bancocomercio.model.User

interface MainContract {

    interface View {
        fun initView()
        fun updateViewData(body: List<User>?)
        fun selectedUser(position: Int)
        fun updateViewDataUser(usuario: User?)
    }

    interface Presenter {
        fun callUsers()
        fun uiAutoUpdate(body: List<User>?)
        fun showUser(position: Int)
        fun uiPopUpUpdate(usuario: User?)
    }

    interface Model {
        fun getUsers(presenter: Presenter)
        fun getUser(presenter: Presenter, position: Int)
    }

}