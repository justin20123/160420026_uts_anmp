package com.example.a160420026_uts_anmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420026_uts_anmp.R
import com.example.a160420026_uts_anmp.model.Book
import kotlinx.android.synthetic.main.book_list_item.view.*

class BookListAdapter(val bookList:ArrayList<Book>):RecyclerView.Adapter<BookListAdapter.BookListHolder>() {
    class BookListHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.book_list_item, parent, false)
        return BookListHolder(view)

    }

    override fun onBindViewHolder(holder: BookListHolder, position: Int) {
        holder.view.textTitle.text = bookList[position].title
        holder.view.txtPhoneNumber.text = bookList[position].subtitle
        holder.view.textAuthorDetail.text = bookList[position].author
        holder.view.btnDetail.setOnClickListener {
            val action = BookListFragmentDirections.actionDetailFragment(bookList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun updateBookList(newBookList: ArrayList<Book>) {
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged()
    }


}