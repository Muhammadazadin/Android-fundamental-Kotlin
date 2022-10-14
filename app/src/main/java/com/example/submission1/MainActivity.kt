package com.example.submission1

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity(){
    private lateinit var adapter: Adapter<Any?>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataAvatar: TypedArray
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.list)
        adapter = Adapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener{_,_, position,_->
            User(
                users[position].username,
                users[position].name,
                users[position].repository,
                users[position].company,
                users[position].followers,
                users[position].following,
                users[position].avatar,
                dataAvatar.getResourceId(position, -1)

            )
            val detailActivityIntent = Intent(this@MainActivity, DetailActivity::class.java)
            val user = ""
            detailActivityIntent.putExtra(DetailActivity.EXTRA_USER,user)
            startActivity(detailActivityIntent)
        }
    }

    private fun prepare(){
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollowing = resources.getStringArray(R.array.following)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)

    }

    private fun addItem(){
        for (position in dataName.indices){
            val user = User(
                dataUsername[position],dataName[position],dataLocation[position],dataRepository[position],
                dataCompany[position],dataFollowing[position],dataFollowers[position],dataAvatar.getResourceId(position, -1)
            )
            users.add(user)
        }
        adapter.user = users

    }


}