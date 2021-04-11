package com.mergenc.nasappcent.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mergenc.nasappcent.R
import com.mergenc.nasappcent.adapter.MarsAdapter
import com.mergenc.nasappcent.viewmodel.CuriosityViewModel
import kotlinx.android.synthetic.main.fragment_curiosity.*

class CuriosityFragment : Fragment() {
    private lateinit var viewModel: CuriosityViewModel
    private val marsAdapter = MarsAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_curiosity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CuriosityViewModel::class.java)
        viewModel.refreshData()

        curiosityList.layoutManager = LinearLayoutManager(context)
        curiosityList.adapter = marsAdapter

        observeLiveData()
    }

    fun observeLiveData() {
        viewModel.marsPhotos.observe(viewLifecycleOwner, Observer { marsPhotos ->
            marsPhotos?.let {
                curiosityList.visibility = View.VISIBLE
                marsAdapter.updateMarsList(marsPhotos)
            }
        })

        viewModel.photosError.observe(viewLifecycleOwner, Observer { photosError ->
            photosError?.let {
                if (it) {
                    curiosityError.visibility = View.VISIBLE
                } else {
                    curiosityError.visibility = View.GONE
                }
            }
        })

        viewModel.photosLoading.observe(viewLifecycleOwner, Observer { photosLoading ->
            photosLoading?.let {
                if(it) {
                    curiosityLoading.visibility = View.VISIBLE
                    curiosityList.visibility = View.GONE
                    curiosityError.visibility = View.GONE
                } else {
                    curiosityLoading.visibility = View.GONE
                }
            }
        })
    }

}