package com.example.a160420026_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.a160420026_uts_anmp.R
import com.example.a160420026_uts_anmp.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.fragment_book_list.*

class BookListFragment : Fragment() {
    private lateinit var viewModel: BookViewModel
    private val bookListAdapter = BookListAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        viewModel.refresh()

        val recView = view.findViewById<RecyclerView>(R.id.recView)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = bookListAdapter

        observeViewModel()

        val refreshLayout = view?.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        refreshLayout.setOnRefreshListener {
            recView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }




    }

    fun observeViewModel() {
        viewModel.booksLD.observe(viewLifecycleOwner, Observer {
            bookListAdapter.updateStudentList(it)

        })

        viewModel.bookLoadErrorLD.observe(viewLifecycleOwner, Observer{
            if(it==true){
                txtError.visibility = View.VISIBLE
            }
            else{
                txtError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer{
            if(it==true){
                recView.visibility=View.GONE
                progressLoad.visibility=View.VISIBLE
            }
            else{
                recView.visibility=View.VISIBLE
                progressLoad.visibility=View.GONE
            }
        })


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

}