package com.example.a160420026_uts_anmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420026_uts_anmp.R
import com.example.advweek4.model.Book
import kotlinx.android.synthetic.main.book_list_item.view.*

class BookListAdapter(val bookList:ArrayList<Book>):RecyclerView.Adapter<BookListAdapter.BookListHolder>() {
    class BookListHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.book_list_item, parent, false)
        return BookListHolder(view)

    }

    override fun onBindViewHolder(holder: BookListHolder, position: Int) {
        holder.view.txtTitle.text = bookList[position].id
        holder.view.txtSubtitle.text = bookList[position].subtitle
        holder.view.txtAuthor.text = bookList[position].author
        holder.view.btnEdit.setOnClickListener {
            val action = BookListFragmentDirections.actionEditBook(bookList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun updateStudentList(newStudentList: ArrayList<Book>) {
        bookList.clear()
        bookList.addAll(newStudentList)
        notifyDataSetChanged()
    }


}