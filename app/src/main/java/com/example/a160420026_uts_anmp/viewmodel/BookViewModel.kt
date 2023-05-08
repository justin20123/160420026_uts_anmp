package com.example.a160420026_uts_anmp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advweek4.model.Book
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BookViewModel(application: Application): AndroidViewModel(application) {
    val booksLD = MutableLiveData<ArrayList<Book>>()
    val bookLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null


    fun refresh() {
        loadingLD.value = true
        bookLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/nanotaboada/6396437/raw/855dd84436be2c86e192abae2ac605743fc3a127/books.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                Log.d("showvoley", it)
                val sType = object : TypeToken<ArrayList<Book>>() { }.type
                val result = Gson().fromJson<ArrayList<Book>>(it, sType)
                booksLD.value = result
                loadingLD.value = false

                Log.d("showvoley", result.toString())


            },
            {
                Log.d("showvoley", it.toString())
                bookLoadErrorLD.value = false
                loadingLD.value = false
            },


            )
        stringRequest.tag = TAG
        queue?.add(stringRequest)



    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}