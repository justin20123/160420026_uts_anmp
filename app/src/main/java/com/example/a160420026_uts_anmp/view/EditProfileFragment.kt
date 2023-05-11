package com.example.a160420026_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.a160420026_uts_anmp.R
import com.example.a160420026_uts_anmp.viewmodel.BookViewModel
import com.example.a160420026_uts_anmp.viewmodel.ProfileViewModel

class EditProfileFragment : Fragment() {
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtPhoneNumber = view.findViewById<TextView>(R.id.txtPhoneNumber)
        val txtFavBook = view.findViewById<TextView>(R.id.txtFavBook)
        val btnBackProfile = view.findViewById<Button>(R.id.btnBackProfile)

        btnBackProfile.setOnClickListener {
            viewModel.profileLD.value?.name = txtName.text.toString()
            viewModel.profileLD.value?.phoneNumber = txtPhoneNumber.text.toString()
            viewModel.profileLD.value?.favoriteBook = txtFavBook.text.toString()
        }
        viewModel.profileLD.value?.name
    }
}