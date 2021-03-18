package com.banco.bancocomercio.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.banco.bancocomercio.R
import com.banco.bancocomercio.contract.MainContract
import com.banco.bancocomercio.model.User

class AdapterUsers(private val list: List<User>?, internal var listener: MainContract.View): RecyclerView.Adapter<AlarmsViewHolder>() {
    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AlarmsViewHolder(inflater, parent, listener)
        context = parent.context
    }

    override fun onBindViewHolder(holder: AlarmsViewHolder, position: Int) {
        val user: User = list!!.get(position)
        holder.bind(user, position)
    }

    override fun getItemCount(): Int = list!!.size
}

class AlarmsViewHolder(inflater: LayoutInflater, parent: ViewGroup, internal var listener: MainContract.View) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_user, parent, false)) {
    private var mListener: MainContract.View = listener
    private var tvUsuario: TextView? = null
    private var content: LinearLayout? = null

    init {
        tvUsuario = itemView.findViewById(R.id.tvUsuario)
        content = itemView.findViewById(R.id.content)
    }

    fun bind(user: User, position: Int) {
        tvUsuario!!.text = user.name

        content?.setOnClickListener(View.OnClickListener {
            mListener.selectedUser(position)
        })
    }
}