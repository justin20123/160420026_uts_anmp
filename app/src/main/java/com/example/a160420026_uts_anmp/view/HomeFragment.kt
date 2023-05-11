package com.example.a160420026_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.a160420026_uts_anmp.R
import com.example.a160420026_uts_anmp.viewmodel.DetailViewModel

class HomeFragment : Fragment() {

    private lateinit var viewModel : DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnSearch = view.findViewById<Button>(R.id.btnSearch)

        btnSearch.setOnClickListener{
            val action = HomeFragmentDirections.actionBookList()
            Navigation.findNavController(it).navigate(action)
        }
    }

}