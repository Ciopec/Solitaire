package com.ciopec.solitaire

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by a626983 on 06.08.2017.
 */
class WastePileView(context: Context) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onWasteTap()
        }
    }

    fun update() {
        val cards = GameModel.wastePile
        imageResource = if (cards.size > 0) getResIdForCard(cards.last()) else emptyPileDrawable
    }

}

fun ViewManager.wastePileView(init: WastePileView.() -> Unit = {}) =
        ankoView({ WastePileView(it) }, 8, init)