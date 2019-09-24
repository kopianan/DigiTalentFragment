package com.kopianan.digitalentsubmission


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kopianan.digitalentsubmission.adapter.TvShowAdapter
import com.kopianan.digitalentsubmission.data.TvShowData
import com.kopianan.digitalentsubmission.models.TvShowModel
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment(), TvShowAdapter.ActionClick {
    override fun onclickTvShow(context: Context, id: TvShowModel) {
        DetailMovieActivity.launchIntentWithDataTvShow(context!!, id)
    }



    var movieList : List<TvShowModel>? = null


    fun newInstance (param1 : String, param2:String): TvShowFragment{
        var fragment  : TvShowFragment = TvShowFragment()
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

        val view = inflater.inflate(R.layout.fragment_tv_show, container, false)
        var recyclerView = view.findViewById(R.id.rv_tv_show) as RecyclerView
        val mLayoutManager = LinearLayoutManager(activity)
        recyclerView.setLayoutManager(mLayoutManager)
        recyclerView.setItemAnimator(DefaultItemAnimator())
        recyclerView.setNestedScrollingEnabled(false)
        // Inflate the layout for this fragment

        movieList = TvShowData().getAllData().shuffled(Random())


        recyclerView.setAdapter(TvShowAdapter(movieList!!,activity!!, this))


        return view
    }


}
