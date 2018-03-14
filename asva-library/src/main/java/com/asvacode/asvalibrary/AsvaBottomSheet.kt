package com.asvacode.asvalibrary


import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asvacode.asvalibrary.adapter.AsvaListAdapter
import com.asvacode.asvalibrary.adapter.item.AsvaItem


/**
 * A simple [Fragment] subclass.
 */
class AsvaBottomSheet : BottomSheetDialogFragment() , AsvaItemClickListener{
    private var adapter : AsvaListAdapter? = null
    private var lstItems = ArrayList<AsvaItem>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView : View = inflater!!.inflate(R.layout.fragment_asva_bottom_sheet, container, false)

        mockItem()

        var recyclerView = rootView.findViewById(R.id.recyclerBottomSheet) as RecyclerView

        adapter = AsvaListAdapter(lstItems)
        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        adapter?.clickListener = this

        //Listener
        return rootView
    }

    override fun onItemClick(view: View, position: Int) {
        Log.d("TAG", "$position")
    }

    private fun mockItem(){
        for(i in 0 until 4){
            var item : AsvaItem = AsvaItem()
            item.descRes = R.string.app_name
            lstItems.add(item)
        }
    }

}
