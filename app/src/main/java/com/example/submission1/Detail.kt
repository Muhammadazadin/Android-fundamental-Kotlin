package com.example.submission1


import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class DetailActivity<user : Parcelable?> : AppCompatActivity(),View.OnClickListener{
    companion object{
        const val EXTRA_USER = "extra_user"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val Name: TextView = findViewById(R.id.name)
        val Repository: TextView = findViewById(R.id.repository)
        val Company: TextView = findViewById(R.id.company)
        val Followers: TextView = findViewById(R.id.followers)
        val Following: TextView = findViewById(R.id.following)
        val Avatar: ImageView = findViewById(R.id.avatar_user)
        val btnShare: Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener(this)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        this.title = "Detail User - ${user.username}"
        Name.text = user.name
        Repository.text = user.repository
        Company.text = user.company
        Followers.text = user.followers
        Following.text = user.following
        Glide.with(this).load(user.avatar).into(Avatar)

    }

    override fun onClick(v: View) {
        val user = intent.getParcelableExtra<user>(EXTRA_USER) as User
        if (v.id == R.id.btn_share){
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TITLE, "Github User ${user.name}")
                putExtra(Intent.EXTRA_TEXT, "https://github.com/${user.username}")
                type = "text/plain"

            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }
}
