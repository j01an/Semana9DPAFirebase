package com.example.semana9dpafirebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.semana9dpafirebase.R
import com.example.semana9dpafirebase.model.ProductModel
import com.squareup.picasso.Picasso

class ProductAdapter(private var lstProducts: List<ProductModel>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tvProductDescr: TextView = itemView.findViewById(R.id.tvProductDescr)
        val tvProductPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val ivProduct: ImageView=itemView.findViewById(R.id.ivProduct)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_product, parent, false))
    }

    override fun getItemCount(): Int {
        return lstProducts.size
    }
    //asas

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemProduct= lstProducts[position]
        holder.tvProductDescr.text=itemProduct.description
        holder.tvProductPrice.text=itemProduct.price
        Picasso.get().load(itemProduct.imageUrl).into(holder.ivProduct)
    }
}