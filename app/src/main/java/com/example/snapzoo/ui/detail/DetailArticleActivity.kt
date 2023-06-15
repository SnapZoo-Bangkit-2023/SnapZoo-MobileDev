package com.example.snapzoo.ui.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.snapzoo.databinding.ActivityDetailArticleBinding


class DetailArticleActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailArticleBinding

    companion object{
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_AVATAR = "extra_avatar"
    }



    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val image = intent.getStringExtra(EXTRA_AVATAR)
        val bundle = Bundle()
        bundle.putString(EXTRA_TITLE,title)


        binding.apply {
                tvDetailArticle.text = title
                tvDetailDescArticle.text = desc
                ivDetailArticle.setImageResource(image!!.toInt())

        }

    }

}
