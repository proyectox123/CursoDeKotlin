package com.platzistore.mho.platzistore

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.platzistore.mho.platzistore.model.ItemLanding
import com.platzistore.mho.platzistore.utils.inflate
import kotlinx.android.synthetic.main.item_landing.view.*

/**
 * Created by Mauricio Hernández on 14-Nov-17.
 */
class AdapterLanding(val data: List<ItemLanding>): RecyclerView.Adapter<AdapterLanding.Holder>() {

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
            Holder(parent?.inflate(R.layout.item_landing))

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindView(data[position])
    }

    class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        fun bindView(itemLanding: ItemLanding){
            with(itemLanding) {
                itemView.txtTitleItem.text = title
                itemView.txtTitleDesc.text = desc
                itemView.txtTitlePrice.text = "$ ${String.format("%.2f", price)}"
            }
        }
    }
}