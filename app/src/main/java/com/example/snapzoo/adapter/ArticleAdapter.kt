package com.example.snapzoo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.snapzoo.databinding.CardviewItemBinding
import com.example.snapzoo.model.ArticleData



class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.AnimalViewHolder>() {


    private var list : List<ArticleData>? = null
    private var onItemClickCallback: OnItemClickCallback?=null





    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(list: List<ArticleData>?) {
        this.list = list

    }


    inner class AnimalViewHolder(val binding: CardviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticleData) {
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClick(article)
            }
            binding.apply{
                ivGridAnimal.setImageResource(article.Image.toInt())
                tvGridTitle.text = article.title
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = CardviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(view)
    }


    override fun getItemCount(): Int {
        if(list == null)return 0
        else return list?.size!!

    }


    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(list?.get(position)!!)


    }

    interface  OnItemClickCallback{
        fun onItemClick(data: ArticleData)
    }
}
