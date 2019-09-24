package com.kopianan.digitalentsubmission


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kopianan.digitalentsubmission.adapter.MovieAdapter
import com.kopianan.digitalentsubmission.models.MovieModel
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kopianan.digitalentsubmission.data.MovieData
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment(), MovieAdapter.ActionClick  {
    override fun onclick(context: Context?, id: MovieModel) {

        DetailMovieActivity.launchIntentWithData(context!!, id)
    }



    var movieList : List<MovieModel>? = null


    fun newInstance (param1 : String, param2:String): MovieFragment{
        var fragment  : MovieFragment = MovieFragment()
        var args : Bundle = Bundle()
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        var recyclerView = view.findViewById(R.id.rv_movie) as RecyclerView
        val mLayoutManager = LinearLayoutManager(activity)
        recyclerView.setLayoutManager(mLayoutManager)
        recyclerView.setItemAnimator(DefaultItemAnimator())
        recyclerView.setNestedScrollingEnabled(false)
        // Inflate the layout for this fragment

//        movieList = MovieData().getAllData()
        movieList = MovieData().getAllData().shuffled(Random())


        recyclerView.setAdapter(MovieAdapter(movieList!!, activity, this))

        return view

    }


}
