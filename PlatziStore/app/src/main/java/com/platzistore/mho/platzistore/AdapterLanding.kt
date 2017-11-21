package com.platzistore.mho.platzistore

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.platzistore.mho.platzistore.model.ItemLanding
import com.platzistore.mho.platzistore.utils.inflate
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.item_landing.view.*

/**
 * Created by Mauricio Hernández on 14-Nov-17.
 */
class AdapterLanding(val data: List<ItemLanding?>?): RecyclerView.Adapter<AdapterLanding.Holder>() {

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
            Holder(parent?.inflate(R.layout.item_landing))

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        data?.let {
            holder?.bindView(it[position])
        }
    }

    class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        fun bindView(itemLanding: ItemLanding?){
            itemLanding?.let {
                with(it) {
                    itemView.txtTitleItem.text = title
                    itemView.txtTitleDesc.text = desc
                    itemView.txtTitlePrice.text = "$ ${String.format("%.2f", price)}"

                    Glide.with(itemView.context)
                            .load(imageUrl)
                            .into(itemView.imageHeaderItem)

                    itemView.setOnClickListener {
                        val intent = Intent(itemView.context, DetailActivity::class.java)
                        intent.putExtra("title", title)
                        intent.putExtra("desc", desc)
                        intent.putExtra("price", price)

                        val pairHeader: Pair<View, String> =
                                Pair.create(itemView.imageHeaderItem,
                                        itemView.context.getString(R.string.transition_header))
                        val pairTitle: Pair<View, String> =
                                Pair.create(itemView.txtTitleItem,
                                        itemView.context.getString(R.string.transition_title))
                        val pairDesc: Pair<View, String> =
                                Pair.create(itemView.txtTitleDesc,
                                        itemView.context.getString(R.string.transition_desc))
                        val pairPrice: Pair<View, String> =
                                Pair.create(itemView.txtTitlePrice,
                                        itemView.context.getString(R.string.transition_price))

                        val options: ActivityOptionsCompat =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity,
                                        pairHeader, pairTitle, pairDesc, pairPrice)
                        itemView.context.startActivity(intent, options.toBundle())
                    }
                }
            }
        }
    }
}