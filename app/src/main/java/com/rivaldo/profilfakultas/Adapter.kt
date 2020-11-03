package com.rivaldo.profilfakultas

import android.graphics.drawable.Drawable
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list.view.*

class Adapter(private val list : ArrayList<Fakultas>): RecyclerView.Adapter<Adapter.Holder>() {

    private var onItemClickCallback : OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    inner class Holder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(fakultasItems: Fakultas){
            with(view) {


                textViewJudul.text = fakultasItems.name
                //textView2.text = fakultasItems.desc
                imgLogo.setImageResource(fakultasItems.image)
                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(fakultasItems)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])


    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback {
        fun onItemClicked(data:Fakultas)
    }
}