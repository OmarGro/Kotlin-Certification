package com.omar.guerrero.kotlin.kotlincertification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val ID = "DetailActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val id = intent.getIntExtra(ID , -1)
        MediaProvider.getDataSource.find { it.id == id }?.let {item ->
            supportActionBar?.title = item.title
            Picasso.get().load(item.thumbUrl).into(detail_thumb)
            detail_video_indicator.visibility = when(item.type){
                MediaItem.Type.PHOTO -> View.GONE
                MediaItem.Type.VIDEO -> View.VISIBLE
            }
        }
    }
}
