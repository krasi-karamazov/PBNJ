package com.appsbg.presentation.view.casinos

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appsbg.presentation.R
import com.appsbg.presentation.base.BaseActivity
import com.appsbg.presentation.factory.ViewModelFactory
import com.appsbg.presentation.state.Resource
import com.appsbg.presentation.view.casinos.adapter.CasinosListAdapter
import com.appsbg.presentation.viewmodel.casinos.CasinosListViewModel
import kotlinx.android.synthetic.main.content_list_casinos.*
import javax.inject.Inject

class CasinosListActivity: BaseActivity(), LifecycleOwner {

    @Inject
    internal lateinit var vmFactory:ViewModelFactory

    private lateinit var viewModel: CasinosListViewModel

    private val casinosAdapter: CasinosListAdapter by lazy {
        CasinosListAdapter{casino ->
            viewModel.openCasinoDetails(casino)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = vmFactory.get()
        viewModel.getCasinos().observe(this, Observer {
            when (it) {
                is Resource.Loading -> Log.d("LOADING", "LOADING")
                is Resource.Error -> Log.d("ERROR", it.message)
                else -> {
                    casinosAdapter.data = it.data!!
                }
            }
        })
        initView()
    }

    private fun initView() {
        casinos_recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        casinos_recycler_view.adapter = casinosAdapter
    }

    override fun getLayoutId(): Int = R.layout.activity_list_casinos
}