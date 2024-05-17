package com.abc.tasktwo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.BundleCompat
import com.abc.tasktwo.databinding.ActivityPostDetailsBinding
import com.abc.tasktwo.model.Post
import com.abc.tasktwo.utils.Constants
import com.bumptech.glide.Glide

class PostDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val post = intent.getParcelableExtra<Post>(Constants.POST)

        intent.extras?.let {

            val post = BundleCompat.getParcelable(it, Constants.POST, Post::class.java)

            if (post != null){
                binding.apply {

                    Glide.with(this@PostDetailsActivity).load(post.url).into(ivPost)

                    tvTitle.text = post.title
                    tvBody.text = post.body
                }
            }

        }



    }
}