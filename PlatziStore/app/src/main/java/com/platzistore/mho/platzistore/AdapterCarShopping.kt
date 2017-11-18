package com.platzistore.mho.platzistore

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.platzistore.mho.platzistore.model.ItemListPOJO
import com.platzistore.mho.platzistore.view.ItemList
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.annotations.NotNull

/**
 * Created by Mauricio Hernández on 15-Nov-17.
 */
class AdapterCarShopping(@NotNull var dataList: List<ItemListPOJO>) : RecyclerView.Adapter<AdapterCarShopping.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
            Holder(ItemList().createView(AnkoContext.Companion.create(parent!!.context, this, false)))

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindView(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    fun addItems(dataList: List<ItemListPOJO>){
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val txtViewTitle by lazy { itemView.find<TextView>(R.id.txtTitleItemAnko) }
        val txtViewDesc by lazy { itemView.find<TextView>(R.id.txtDescItemAnko) }
        val txtViewPrice by lazy { itemView.find<TextView>(R.id.txtPriceItemAnko) }

        fun bindView(item: ItemListPOJO){
            with(item){
                txtViewTitle.text = title
                txtViewDesc.text = desc
                txtViewPrice.text = "$ ${price}"
            }
        }
    }
}