package com.example.semana9dpafirebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.semana9dpafirebase.R
import com.example.semana9dpafirebase.model.PokemonModel
import com.squareup.picasso.Picasso

class PokemonAdapter(private var pokemonList: List<PokemonModel>)
    : RecyclerView.Adapter<PokemonAdapter.ViewHolder>()
{
        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val ivPokemon: ImageView = itemView.findViewById(R.id.ivPokemon)
            val tvPokemonName: TextView = itemView.findViewById(R.id.tvPokemonName)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon,parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemonItem = pokemonList[position]
        holder.tvPokemonName.text =pokemonItem.name.toString()
        Picasso.get().load(pokemonItem.url).into(holder.ivPokemon)
    }

    fun setDate(pokemonList: List<PokemonModel>){
        this.pokemonList=pokemonList
        notifyDataSetChanged()
    }
}