package com.kopianan.digitalentsubmission.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kopianan.digitalentsubmission.R
import com.kopianan.digitalentsubmission.models.MovieModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie_list.view.*

class MovieAdapter(list: List<MovieModel>, context: Context?, action: ActionClick) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var mContext = context
    var mList = list
    var mAction =action



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_movie_list, parent, false))

    }

    override fun getItemCount(): Int {
        return mList!!.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView()

    }

    inner class ViewHolder(itemView: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bindView() {

            itemView.tv_movie_list_title.text = mList[adapterPosition].Title
            itemView.tv_movie_list_year.text = mList[adapterPosition].Year


            Picasso.get().load(mList[adapterPosition].Poster).into(itemView.iv_movie_list_photo);

            itemView.cv_film_list_item.setOnClickListener {
                mAction.onclick(mContext,mList[adapterPosition])
            }


        }

    }
    interface ActionClick {
        fun onclick(context: Context?,id: MovieModel)
    }


}