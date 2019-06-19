package com.appsbg.presentation.view.casinos.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appsbg.model.poko.casinos.Casino
import com.appsbg.presentation.R
import kotlinx.android.synthetic.main.list_item.view.*

class CasinosListAdapter: RecyclerView.Adapter<CasinosListAdapter.CasinosViewHolder>() {

    private var data: List<Casino> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CasinosViewHolder = CasinosViewHolder(View.inflate(parent.context, R.layout.list_item, null))

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CasinosViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class CasinosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(casino: Casino, listener: (Int, String) -> Unit) = with(itemView){
            //thumb.ima
        }
    }
}