package berk.bilgiyarismasi.util.extensions

import android.view.ViewGroup

fun ViewGroup.changeViewGroupState(enable: Boolean) {
    for (item in 0 until childCount) {
        val child = getChildAt(item)
        child.isEnabled = enable
    }
}