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
import kotlinx.android.synthetic.main.fragment_book_detail.*



class BookDetailFragment : Fragment() {
    private lateinit var viewModel : DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments!=null){
            viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

            val bookId = BookDetailFragmentArgs.fromBundle(requireArguments()).bookId
            viewModel.getData(bookId.toInt())
            val textTitleDetail = view.findViewById<TextView>(R.id.textTitleDetail)
            val textSubtitleDetail = view.findViewById<TextView>(R.id.textSubtitleDetail)
            val textAuthorDetail = view.findViewById<TextView>(R.id.textAuthorDetail)
            val textDescriptionDetail = view.findViewById<TextView>(R.id.textDescriptionDetail)

            //Log.d("test", viewModel.booksLD.value?.toString().toString())

            if(viewModel.booksLD.value?.title !=null){
                textTitleDetail.text = viewModel.booksLD.value?.title
                textSubtitleDetail.text = viewModel.booksLD.value?.subtitle
                textAuthorDetail.text = viewModel.booksLD.value?.author
                textDescriptionDetail.text = viewModel.booksLD.value?.description
                btnEdit.setOnClickListener{
                    val action = BookDetailFragmentDirections.actionEditFragment(bookId)
                    Navigation.findNavController(it).navigate(action)
                }
                btnDetailBack.setOnClickListener{
                    val action = BookDetailFragmentDirections.actionBackDetail()
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }
    

}