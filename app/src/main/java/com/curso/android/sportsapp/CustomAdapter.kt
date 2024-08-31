package com.curso.android.sportsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val sportList: List<Sport>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
        private var sportClickListener: SportClickListener? = null
        private val _sportList: List<Sport> = sportList

    fun setClickListener(myListener: SportClickListener?) {
        this.sportClickListener = myListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item_layout, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return _sportList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sport = _sportList[position]
        holder.sportName.text = sport.getSportName()
        holder.sportImage.setImageResource(sport.getSportImage())
    }

    inner class ViewHolder(sportView: View) : RecyclerView.ViewHolder(sportView), View.OnClickListener {
        val sportImage: ImageView = sportView.findViewById(R.id.imageview)
        val sportName: TextView = sportView.findViewById(R.id.tittle)

        init {
            sportView.setOnClickListener(this)
        }


        override fun onClick(view: View) {
            sportClickListener?.onCLick(view, adapterPosition)
        }


    }


}