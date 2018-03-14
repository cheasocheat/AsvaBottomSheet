package com.asvacode.asvalibrary.adapter.item

import com.asvacode.asvalibrary.R

/**
 * Created by cheasocheat on 3/14/18.
 */
class AsvaItem {
    var iconRes: Int? = null
    var descRes: Int? = null
    var desc: String? = null

    constructor(iconRes: Int = R.drawable.monkey, descRes: Int = R.string.default_text, desc: String = "") {
        this.iconRes = iconRes
        this.descRes = descRes
        this.desc = desc
    }
}