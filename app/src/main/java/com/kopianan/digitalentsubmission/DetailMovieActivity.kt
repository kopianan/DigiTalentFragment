package com.kopianan.digitalentsubmission

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kopianan.digitalentsubmission.models.MovieModel
import com.kopianan.digitalentsubmission.models.TvShowModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity(){

    var searchData : MovieModel? = null
    var tvModel : TvShowModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setTitle(R.string.detail_title)

        if(intent.hasExtra("ID")){
             searchData = intent.getParcelableExtra<MovieModel>("ID")
            fillData(searchData)
        }

        if(intent.hasExtra("IDTV")){
            tvModel = intent.getParcelableExtra<TvShowModel>("IDTV")
            fillData(tvModel)
        }



    }


     fun fillData(movie: MovieModel?) {
        Picasso.get().load(movie!!.Poster).into(iv_detail_movie)
        tv_detail_movei_title.text = movie.Title
        tv_detail_movei_genre.text = movie.Genre
        tv_detail_movei_plot.text = movie.Plot
        tv_detail_movei_rate.text = movie.imdbRating
        tv_detail_movei_duration.text = movie.Runtime
        tv_detail_movei_released.text = movie.Released
        tv_detail_movei_actor.text = movie.Actors

    }

    fun fillData(tvShow: TvShowModel?) {
        Picasso.get().load(tvShow!!.Poster).into(iv_detail_movie)
        tv_detail_movei_title.text = tvShow.Title
        tv_detail_movei_genre.text = tvShow.Genre
        tv_detail_movei_plot.text = tvShow.Plot
        tv_detail_movei_rate.text = tvShow.imdbRating
        tv_detail_movei_duration.text = tvShow.Runtime
        tv_detail_movei_released.text = tvShow.Released
        tv_detail_movei_actor.text = tvShow.Actors

    }



    companion object{
        fun launchIntentWithData(context: Context, id:MovieModel){
            val intent = Intent(context.applicationContext, DetailMovieActivity::class.java)
            intent.putExtra("ID", id)
            context.startActivity(intent)

        }

        fun launchIntentWithDataTvShow(context: Context, id:TvShowModel){
            val intent = Intent(context.applicationContext, DetailMovieActivity::class.java)
            intent.putExtra("IDTV", id)
            context.startActivity(intent)

        }
    }
}
