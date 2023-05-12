package com.example.a160420026_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160420026_uts_anmp.R
import com.example.a160420026_uts_anmp.viewmodel.DetailViewModel
import com.example.a160420026_uts_anmp.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_book_detail.*


class ProfileFragment : Fragment() {
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments!=null){
            viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

            val textName = view.findViewById<TextView>(R.id.textName)
            val textPhoneNumber = view.findViewById<TextView>(R.id.textPhoneNumber)
            val textFavBook= view.findViewById<TextView>(R.id.textFavBook)

            //Log.d("test", viewModel.booksLD.value?.toString().toString())

            if(viewModel.profileLD.value?.name !=null){
                textName.text = viewModel.profileLD.value?.name
                textPhoneNumber.text = viewModel.profileLD.value?.phoneNumber
                textFavBook.text = viewModel.profileLD.value?.favoriteBook

            }
        }
    }

}