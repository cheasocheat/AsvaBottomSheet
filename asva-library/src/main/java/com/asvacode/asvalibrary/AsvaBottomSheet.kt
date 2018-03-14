package com.asvacode.asvalibrary


import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asvacode.asvalibrary.adapter.AsvaListAdapter
import com.asvacode.asvalibrary.adapter.item.AsvaItem


/**
 * A simple [Fragment] subclass.
 */
class AsvaBottomSheet : BottomSheetDialogFragment() {
    var adapter: AsvaListAdapter? = null
    var listItems = ArrayList<AsvaItem>()
    var onItemClickListener : AsvaItemClickListener ? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView: View = inflater!!.inflate(R.layout.fragment_asva_bottom_sheet, container, false)
        var recyclerView = rootView.findViewById(R.id.recyclerBottomSheet) as RecyclerView
        if(listItems.isEmpty()){
            listItems.add(AsvaItem(R.drawable.icon, R.string.app_name))
        }
        adapter = AsvaListAdapter(listItems)
        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        adapter?.clickListener = onItemClickListener

        return rootView
    }
}


