package com.abc.tasktwo

import android.content.Context
import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abc.tasktwo.adapter.PostsAdapter
import com.abc.tasktwo.databinding.ActivityMainBinding
import com.abc.tasktwo.model.Post
import com.abc.tasktwo.utils.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jsonString = readTextFileFromAssets(this, "task.txt")

        val type = object : TypeToken<List<Post>>() {}.type
        val posts: List<Post> = Gson().fromJson(jsonString, type)


        val postsAdapter = PostsAdapter(posts)
        postsAdapter.onClickItem = { position ->
            val intent = Intent(this, PostDetailsActivity::class.java)
            intent.putExtra(Constants.POST, posts[position])
            startActivity(intent)
        }

        binding.rvPosts.adapter = postsAdapter

    }

    private fun readTextFileFromAssets(context: Context, fileName: String): String {
        val assetManager: AssetManager = context.assets
        val inputStream = assetManager.open(fileName)
        val bufferedReader = inputStream.bufferedReader()
        val fileContent = bufferedReader.use { it.readText() }
        return fileContent
    }


}