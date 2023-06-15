package com.example.snapzoo.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.snapzoo.adapter.ImageSliderAdapter
import com.example.snapzoo.R
import com.example.snapzoo.adapter.ArticleAdapter
import com.example.snapzoo.databinding.FragmentHomeBinding
import com.example.snapzoo.model.ArticleData
import com.example.snapzoo.model.ImageData
import com.example.snapzoo.ui.detail.DetailArticleActivity


class HomeFragment : Fragment() {


    private var binding : FragmentHomeBinding? = null
    private lateinit var adapter : ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var dots : ArrayList<TextView>

    private lateinit var articleAdapter: ArticleAdapter
    private var articleList = ArrayList<ArticleData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)



            recyclerList()
            if(articleList.isEmpty()){
            articleList.addAll(getListArticle())}
            articleAdapter.setList(articleList)
           articleAdapter.notifyDataSetChanged()



        if(list.isEmpty()){
            list.add(
                ImageData(
                    R.drawable.firstslide
                )
            )
            list.add(
                ImageData(
                    R.drawable.lion
                )
            )
            list.add(
                ImageData(
                    R.drawable.elephant
                )
            )
        }


        adapter = ImageSliderAdapter(list)
        binding!!.vpHome.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding!!.vpHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })


        articleAdapter.setOnItemClickCallback(object : ArticleAdapter.OnItemClickCallback {
            override fun onItemClick(data: ArticleData) {

                Intent(requireContext(), DetailArticleActivity::class.java).also {
                    it.putExtra(DetailArticleActivity.EXTRA_TITLE,data.title)
                    it.putExtra(DetailArticleActivity.EXTRA_DESC, data.desc)
                    it.putExtra(DetailArticleActivity.EXTRA_AVATAR, data.Image)
                    startActivity(it)
                }

            }

        })


        }

    private fun selectedDot(position: Int) {
      for(i in 0 until list.size){
          if(i  == position)
              dots[i].setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
          else
              dots[i].setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
      }
    }



    private fun setIndicator() {
        for ( i in 0 until list.size){
            dots.add(TextView(requireContext()))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dots[i].text = Html.fromHtml("&#9679" , Html.FROM_HTML_MODE_LEGACY).toString()
            } else {
                dots[i].text = Html.fromHtml("&#9679")
            }
            dots[i].textSize = 18f
            binding?.dotHome?.addView(dots[i])
        }
    }

    private fun getListArticle(): ArrayList<ArticleData>{
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listArticle = ArrayList<ArticleData>()
        for (i in dataTitle.indices) {
            val article = ArticleData(dataTitle[i], dataPhoto.getResourceId(i, -1).toString(), dataDescription[i]
            )

            listArticle.add(article)
        }
        return listArticle
    }



    private fun recyclerList(){
        binding?.rvArticle?.layoutManager = LinearLayoutManager(requireContext())
        articleAdapter = ArticleAdapter()
        binding?.rvArticle?.adapter = articleAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }




    }




