package com.ibrajix.snapchatclone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ibrajix.snapchatclone.R
import com.ibrajix.snapchatclone.databinding.FragmentStoriesBinding
import com.ibrajix.snapchatclone.utis.viewBinding


class StoriesFragment : Fragment() {

    private val binding by viewBinding(FragmentStoriesBinding::bind)

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        initView()
    }

    private fun initView(){
        handleClicks()
    }

    private fun handleClicks(){

        //on click stories
        binding.storiesView.setOnClickListener {

            val action = StoriesFragmentDirections.actionStoriesFragmentToViewStoriesFragment()
            navController.navigate(action)
        }


    }
}