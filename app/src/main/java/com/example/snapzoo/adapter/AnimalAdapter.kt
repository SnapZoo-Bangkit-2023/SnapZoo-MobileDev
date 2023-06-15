package com.example.snapzoo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.snapzoo.databinding.ItemListBinding
import com.example.snapzoo.model.AnimalResponse


class AnimalAdapter: RecyclerView.Adapter<AnimalAdapter.UserViewHolder>() {


    private var list : List<AnimalResponse>? = null
    private var onItemClickCallback: OnItemClickCallback?=null
    private var filteredList: MutableList<AnimalResponse>? = null




    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(list: List<AnimalResponse>?) {
        this.list = list
        this.filteredList = list?.toMutableList()
    }

    fun filterList(query: String?) {
        if (query.isNullOrEmpty()) {
            filteredList = list?.toMutableList()
        } else {
            filteredList?.clear()
            list?.forEach { animal ->
                if (animal.name?.contains(query, ignoreCase = true) == true) {
                    filteredList?.add(animal)
                }
            }
        }
        notifyDataSetChanged()
    }

    inner class UserViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: AnimalResponse) {
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClick(animal)
            }
            binding.apply{
               Glide.with(itemView)
                    .load(animal.image)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .circleCrop()
                    .into(imvUser)
                tvName.text = animal.name
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }


    override fun getItemCount(): Int {
        return filteredList?.size ?: 0
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(filteredList?.get(position)!!)


    }

    interface  OnItemClickCallback{
        fun onItemClick(data: AnimalResponse)
    }
}

