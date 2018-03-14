package com.asvacode.asvabottomsheet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.asvacode.asvalibrary.AsvaBottomSheet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnShowBottomSheet.setOnClickListener({
            var dialog  = AsvaBottomSheet()
            dialog.show(supportFragmentManager, "TAG")
        })
    }
}
