package com.asvacode.asvalibrary.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.asvacode.asvalibrary.AsvaItemClickListener
import com.asvacode.asvalibrary.adapter.item.AsvaItem
import com.asvacode.asvalibrary.R
import com.asvacode.asvalibrary.extension.loadLocal
import kotlinx.android.synthetic.main.asva_list_item.view.*
import android.view.LayoutInflater


/**
 * Created by cheasocheat on 3/14/18.
 */
class AsvaListAdapter() : RecyclerView.Adapter<AsvaListAdapter.AsvaViewHolder>() {

    private var lstAsvaItems: ArrayList<AsvaItem> = ArrayList()
    var clickListener: AsvaItemClickListener? = null

    constructor(lstAsvaItems: ArrayList<AsvaItem>) : this() {
        this.lstAsvaItems = lstAsvaItems
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AsvaViewHolder {
        // var view  = parent?.inflate(R.layout.asva_list_item, ,false)
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.asva_list_item, parent, false)

        return AsvaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return lstAsvaItems.size
    }

    override fun onBindViewHolder(holder: AsvaViewHolder?, position: Int) {
        holder?.bindData(lstAsvaItems[position])
    }


    inner class AsvaViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView?.setOnClickListener(this)
        }

        fun bindData(item: AsvaItem) = with(itemView) {
            this.imgIcon.loadLocal(item.iconRes!!)
            if (item.desc!!.isEmpty()) {
                this.tvDesc.text = resources.getText(item.descRes!!)
            } else {
                this.tvDesc.text = item.desc
            }
        }

        override fun onClick(v: View?) {
            clickListener.let {
                clickListener?.onItemClick(itemView, adapterPosition)
            }
        }
    }
}