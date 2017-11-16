package com.platzistore.mho.platzistore.view

import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.platzistore.mho.platzistore.AdapterCarShopping
import com.platzistore.mho.platzistore.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by Mauricio Hernández on 15-Nov-17.
 */

class ItemList : AnkoComponent<AdapterCarShopping> { //All views init with wrap_content by default

    override fun createView(ui: AnkoContext<AdapterCarShopping>): View = with(ui){
        verticalLayout {
            lparams(width = matchParent, height = wrapContent)
            cardView { //CardView
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    lparams(width = matchParent)
                    imageView(R.mipmap.ic_launcher_round) { //ImageItem
                        id = R.id.imgItem
                        scaleType = ImageView.ScaleType.CENTER_CROP
                    }.lparams(width = dip(0), height = dip(100), weight = 1f)

                    linearLayout { //Content information
                        padding = dip(5)
                        orientation = LinearLayout.VERTICAL
                        textView("Title") { //Title
                            id = R.id.txtTitleItemAnko
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Large)
                        }
                        textView("Desc") { //Desc
                            id = R.id.txtDescItemAnko
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Small)
                        }
                        textView("Price") { //Price
                            id = R.id.txtPriceItemAnko
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Medium)
                            textColor = resources.getColor(R.color.colorAccent)
                        }.lparams {
                            topMargin = dip(5)
                            gravity = Gravity.END
                        }
                    }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                }
            }
        }
    }

}