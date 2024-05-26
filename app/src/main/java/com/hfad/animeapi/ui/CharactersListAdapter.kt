package com.hfad.animeapi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.hfad.animeapi.R
import com.hfad.animeapi.data.model.DataModel
import com.hfad.animeapi.databinding.ElementCharacterBinding

class CharactersListAdapter(
    private val charactersList:List<DataModel?>?
): RecyclerView.Adapter<CharactersListAdapter.MyViewHolder>(){

inner class MyViewHolder(itemView:View):ViewHolder(itemView){
    private val binding = ElementCharacterBinding.bind(itemView)

    fun updateUI(characterItemModel:DataModel?){
        binding.apply {
            Glide.with(itemView.context).load(characterItemModel?.images?.jpg?.imageUrl).placeholder(R.drawable.person_icon).into(ivCharacterPic)
            tvCharacterName.text = characterItemModel?.name
        }
    }

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.element_character, parent,false))
    }

    override fun getItemCount(): Int = charactersList?.size?:0

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.updateUI(charactersList?.get(position))
    }


}