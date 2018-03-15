package com.asvacode.asvabottomsheet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.asvacode.asvabottomsheet.AsvaBottomSheet
import com.asvacode.asvabottomsheet.AsvaItemClickListener
import com.asvacode.asvabottomsheet.adapter.item.AsvaItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), AsvaItemClickListener {
    var listItems: ArrayList<AsvaItem> = ArrayList()
    var dialog: AsvaBottomSheet? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mock()

        btnShowBottomSheet.setOnClickListener({
            dialog = AsvaBottomSheet()
            dialog!!.listItems = listItems
            dialog!!.show(supportFragmentManager, "TAG")
            dialog!!.onItemClickListener = this
        })
    }

    fun mock() {
        var item1 = AsvaItem(desc = "Preview")
        var item2 = AsvaItem(desc = "Share")
        var item3 = AsvaItem(desc = "Save")
        var item4 = AsvaItem(desc = "Bookmark")

        listItems.add(item1)
        listItems.add(item2)
        listItems.add(item3)
        listItems.add(item4)
    }

    override fun onItemClick(view: View, position: Int) {
        toast("You clicked at position : $position")
        dialog?.dismiss()
    }

}
