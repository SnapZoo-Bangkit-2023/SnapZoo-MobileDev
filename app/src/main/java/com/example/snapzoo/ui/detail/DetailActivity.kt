package com.example.snapzoo.ui.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.snapzoo.databinding.ActivityDetailBinding
import com.example.snapzoo.model.AnimalResponse
import com.example.snapzoo.ui.search.SearchFragment

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animal = intent.getParcelableExtra<AnimalResponse>(SearchFragment.INTENT_PARCELABLE)


            binding.apply {
                if (animal != null) {
                    tvNameDetail.text = animal.name
                    includeClassification.tvKingdom.text = animal.kingdom
                    includeClassification.tvPhylum.text = animal.phylum
                    includeClassification.tvClass.text = animal.jsonMemberClass
                    includeClassification.tvOrder.text = animal.order
                    includeClassification.tvFamily.text = animal.family
                    includeClassification.tvGenus.text = animal.genus
                    includeClassification.tvSpecies.text = animal.species
                    descDisplay.text = animal.description
                    reproDisplay.text = animal.reproduction
                    habitatDisplay.text = animal.habitat
                    dietDisplay.text = animal.diet
                }
                Glide.with(this@DetailActivity)
                    .load(animal?.image)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(ivDetailAnimal)
            }

        }

    }
