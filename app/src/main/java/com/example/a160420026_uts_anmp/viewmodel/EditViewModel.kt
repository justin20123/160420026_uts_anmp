package com.example.a160420026_uts_anmp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160420026_uts_anmp.model.Book
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EditViewModel (application: Application): AndroidViewModel(application) {
    val bookLD = MutableLiveData<Book>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun getData(isbn:String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://raw.githubusercontent.com/justin20123/160420026_uts_anmp/master/books.json?isbn=$isbn"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                Log.d("showvoley", it)
                //error panggil gson
                val sType = object : TypeToken<ArrayList<Book>>() { }.type
                val result = Gson().fromJson<ArrayList<Book>>(it, Book::class.java)
                bookLD.value = result[0]

                Log.d("showvoley", result.toString())


            },
            {
//
            },


            )
        stringRequest.tag = TAG
        queue?.add(stringRequest)


    }
}