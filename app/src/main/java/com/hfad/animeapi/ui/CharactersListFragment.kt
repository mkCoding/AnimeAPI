package com.hfad.animeapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.animeapi.databinding.FragmentCharactersListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharactersListFragment : Fragment() {

    private lateinit var binding: FragmentCharactersListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentCharactersListBinding.inflate(inflater,container,false)
        var root = binding.root


        val charactersListViewModel = ViewModelProvider(this)[CharactersListViewModel::class.java]

        charactersListViewModel.getAllCharacters()
        charactersListViewModel.charactersList.observe(viewLifecycleOwner){
            binding.rvCharacters.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = CharactersListAdapter(it.data) //pass in the actual character list (it.data)
            }

        }
        // Inflate the layout for this fragment
        return root
    }

}