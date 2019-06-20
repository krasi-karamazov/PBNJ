package com.appsbg.presentation.view.casinos.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appsbg.model.poko.casinos.Casino
import com.appsbg.presentation.R
import com.appsbg.presentation.utils.Utils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class CasinosListAdapter(private val listener: (String, String) -> Unit): RecyclerView.Adapter<CasinosListAdapter.CasinosViewHolder>() {

    var data: List<Casino> = mutableListOf()
        set(casinos) {
            if(this.data.isNotEmpty()) {
                (data as MutableList).clear()
            }
            (data as MutableList).addAll(casinos)
            this.notifyDataSetChanged()
            field = casinos
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CasinosViewHolder = CasinosViewHolder(View.inflate(parent.context, R.layout.list_item, null))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CasinosViewHolder, position: Int) {
        holder.bind(data[position], listener)
    }


    inner class CasinosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(casino: Casino, listener: (String, String) -> Unit) = with(itemView){
            Picasso.get().load(Utils.imageUrlThumb(casino.images[0].filename)).into(this.thumb)
            this.name.text = casino.name
            this.setOnClickListener{listener(casino.id, casino.name)}
        }
    }
}