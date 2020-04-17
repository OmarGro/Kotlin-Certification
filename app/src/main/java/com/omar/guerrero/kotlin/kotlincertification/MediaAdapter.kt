package com.omar.guerrero.kotlin.kotlincertification

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_media_item.view.*

class MediaAdapter(var items : List<MediaItem>, val listener: (item :MediaItem) -> Unit) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        private val mediaTitle = itemView.find<TextView>(R.id.mediaTitle)
        private val mediaThumb = itemView.find<ImageView>(R.id.mediaThumb)
        private val mediaVideoIndicator = itemView.find<ImageView>(R.id.mediaVideoIndicator)

        fun bind(item: MediaItem) {
            mediaTitle.text = item.title
            Picasso.get().load(item.thumbUrl).into(mediaThumb)
            mediaVideoIndicator.visibility = when(item.type){
                MediaItem.Type.PHOTO -> View.GONE
                MediaItem.Type.VIDEO -> View.VISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_media_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener { listener(items[position]) }
    }

    override fun getItemCount(): Int = items.size

}