//package com.tanacom.introrealm.kotlin
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.tanacom.introrealm.R
//import io.realm.OrderedRealmCollection
//import io.realm.RealmRecyclerViewAdapter
//
//class CountryAdapter(data: OrderedRealmCollection<CountryModel?>?) :
//
//    RealmRecyclerViewAdapter<CountryModel?, CountryAdapter.MyViewHolder>(data, true) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val itemView =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
//        return MyViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val model = getItem(position)
//        holder.tvCountry.text = model!!.name
//    }
//
//    override fun getItemId(position: Int): Long {
//        return getItem(position)!!.id.toLong()
//    }
//
//    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        var tvCountry: TextView = itemView.findViewById(R.id.tv_item)
//
//    }
//
//    init {
//        // Used when there's primary key in Model
//        setHasStableIds(true)
//    }
//
//
//}