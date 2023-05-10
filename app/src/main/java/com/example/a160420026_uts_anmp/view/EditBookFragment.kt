package com.example.a160420026_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.a160420026_uts_anmp.R
import com.example.a160420026_uts_anmp.viewmodel.BookViewModel
import com.example.a160420026_uts_anmp.viewmodel.EditViewModel
import kotlinx.android.synthetic.main.fragment_book_list.*
import kotlinx.android.synthetic.main.fragment_edit_book.*


class EditBookFragment : Fragment() {

    private lateinit var viewModel : EditViewModel

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
            viewModel = ViewModelProvider(this).get(EditViewModel::class.java)

            val bookId = EditBookFragmentArgs.fromBundle(requireArguments()).bookId
            viewModel.getData(bookId.toInt())
            val txtTitle = view.findViewById<TextView>(R.id.txtTitle)
            val txtSubtitle = view.findViewById<TextView>(R.id.txtSubtitle)
            val txtAuthor = view.findViewById<TextView>(R.id.txtAuthor)
            val txtDesc = view.findViewById<TextView>(R.id.txtDesc)
            val title = viewModel.booksLD.value?.title

            textBookTitle.text = "Edit Book $title"
            txtTitle.text = title
            txtSubtitle.text = viewModel.booksLD.value?.subtitle
            txtAuthor.text = viewModel.booksLD.value?.author
            txtDesc.text = viewModel.booksLD.value?.description

        }
    }


}