package gst.trainingcourse.sampleproject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gst.trainingcourse.sampleproject.R
import gst.trainingcourse.sampleproject.domain.model.CatImage
import kotlinx.android.synthetic.main.item_cat_image.view.*

class CatImageAdapter : PagingDataAdapter<CatImageView, CatImageAdapter.CatImageViewHolder>(
    callback
) {
    override fun onBindViewHolder(holder: CatImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatImageViewHolder {
        return CatImageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_cat_image,
                parent,
                false
            )
        )
    }
    companion object {
        val callback = object : DiffUtil.ItemCallback<CatImageView>() {
            override fun areItemsTheSame(oldItem: CatImageView, newItem: CatImageView): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CatImageView, newItem: CatImageView): Boolean {
                return oldItem == newItem
            }
        }
    }

    class CatImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: CatImageView?) {
            data?.let {
                Picasso.get().load(it.url).into(itemView.img_cat)
            }
        }
    }
}