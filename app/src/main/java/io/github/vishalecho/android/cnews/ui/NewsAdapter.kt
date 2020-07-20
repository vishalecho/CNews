package io.github.vishalecho.android.cnews.ui

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.github.vishalecho.android.cnews.R
import io.github.vishalecho.android.cnews.data.model.News
import io.github.vishalecho.android.cnews.utils.TimesAgo
import kotlinx.android.synthetic.main.layout_item_news.view.*

class NewsAdapter(private val picasso: Picasso) :
    ListAdapter<News, NewsAdapter.ListViewHolder>(NewsDC()) {
    var interaction: Interaction? = null
    private lateinit var newsMutableList: MutableList<News>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.layout_item_news, parent, false),
        interaction
    )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        return holder.bind(getItem(position), picasso)
    }

    fun swapData(news: List<News>) {
        newsMutableList = news.toMutableList()
        submitList(news.toMutableList())
    }

    inner class ListViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView), OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val clickedNews = getItem(adapterPosition)
            interaction?.newsClicked(adapterPosition, clickedNews)
        }

        fun bind(item: News, picasso: Picasso) = with(itemView) {
            picasso.load(item.banner_url).into(ivBannerImage)
            tvTitle.text = item.title
            tvDescription.text = item.description
            tvPostedAt.text = TimesAgo.get(item.time_created)
        }
    }

    interface Interaction {
        fun newsClicked(
            position: Int,
            news: News
        )
    }

    private class NewsDC : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: News, newItem: News) = oldItem == newItem
    }
}