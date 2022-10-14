package com.example.submission1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Adapter<T> internal constructor(private val context: Context): BaseAdapter(){
    var user = arrayListOf<User>()

    override fun getCount(): Int=
        user.size

    override fun getItem(i: Int): Any =
        user[i]

    override fun getItemId(i: Int): Long =
        i.toLong()

    override fun getView(position:  Int, view: View?,viewGroup:  ViewGroup?): View {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup,false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }
    private inner class ViewHolder constructor(view: View){
        private val txtName: TextView = view.findViewById(R.id.text_name)
        private val txtUsername: TextView = view.findViewById(R.id.text_username)
        private val imgAvatar: ImageView = view.findViewById(R.id.img_avatar)
        fun bind(user: User){
            txtName.text = user.name
            txtUsername.text = user.username
            Glide.with(context).load(user.avatar).into(imgAvatar)

        }
    }


}
