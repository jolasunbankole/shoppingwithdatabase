package com.example.groceryapp20

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//  happening inside my cardview
class GroceryRVAdapter (var list: List<GroceryItems>,
                        private val groceryItemClickInterface: GroceryItemClickInterface
                        ): RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>() {

    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTv: TextView = itemView.findViewById(R.id.idTVItemName)
        val quantityTv: TextView = itemView.findViewById(R.id.idTVQuantity)
        val rateTv: TextView = itemView.findViewById(R.id.idTVRate)
        val deleteIV: ImageView = itemView.findViewById(R.id.idTVDelete)
        val amountTv: TextView = itemView.findViewById(R.id.idTotalAmt)
    }

    interface GroceryItemClickInterface{
        fun onItemClick(groceryItems: GroceryItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item, parent, false)
        return GroceryViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        holder.nameTv.text = list[position].itemName
        holder.quantityTv.text = list[position].itemQuantity.toString()
        holder.rateTv.text = "€" + list[position].itemPrice.toString()
        val itemTotal : Int = list[position].itemPrice * list[position].itemQuantity
        holder.amountTv.text = "€$itemTotal"
        holder.deleteIV.setOnClickListener {
            groceryItemClickInterface.onItemClick(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}