package com.example.a160420026_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160420026_uts_anmp.R
import com.example.a160420026_uts_anmp.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_edit_book.*


class EditBookFragment : Fragment() {

    private lateinit var viewModel : DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments!=null){
            viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

            val bookId = EditBookFragmentArgs.fromBundle(requireArguments()).bookId
            viewModel.getData(bookId.toInt())


            val txtTitle = view.findViewById<TextView>(R.id.txtName)
            val txtSubtitle = view.findViewById<TextView>(R.id.txtPhoneNumber)
            val txtAuthor = view.findViewById<TextView>(R.id.txtFavBook)
            val txtDesc = view.findViewById<TextView>(R.id.txtDesc)
            val btnBackEdit = view.findViewById<Button>(R.id.btnBackEdit)

            val title = viewModel.booksLD.value?.title

            textView.text = "Edit Book $title"
            txtTitle.text = title
            txtSubtitle.text = viewModel.booksLD.value?.subtitle
            txtAuthor.text = viewModel.booksLD.value?.author
            txtDesc.text = viewModel.booksLD.value?.description
            btnBackEdit.setOnClickListener {
                val action = EditBookFragmentDirections.actionBackEdit(bookId)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }


}