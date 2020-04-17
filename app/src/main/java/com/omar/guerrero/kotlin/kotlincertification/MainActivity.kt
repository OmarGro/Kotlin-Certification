package com.omar.guerrero.kotlin.kotlincertification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter  = MediaAdapter(MediaProvider.getDataSource){ navigateToDetail(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        //Best option by filter with a data layer on an architecture
        val filter : Filter = when(item.itemId){
            R.id.filter_photos -> Filter.ByType(MediaItem.Type.PHOTO)
            R.id.filter_videos -> Filter.ByType(MediaItem.Type.VIDEO)
            else -> Filter.None
        }

        loadFilterData(filter)

/*

        adapter.items = MediaProvider.getDataSource.let { media ->
            when(item.itemId){
                R.id.filter_all -> media
                R.id.filter_photos -> media.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos -> media.filter { it.type == MediaItem.Type.VIDEO }
                else -> emptyList()
            }
        }*/

        recycler.adapter?.notifyDataSetChanged()

        return true
    }

    private fun loadFilterData(filter: Filter){
        MediaProvider.getDataSource.let { media ->
            adapter.items = when (filter){
                Filter.None -> media
                is Filter.ByType -> media.filter { it.type == filter.type }
            }
        }
    }

    private fun navigateToDetail(item: MediaItem){
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.ID, item.id)
        }
        startActivity(intent)
    }
}
