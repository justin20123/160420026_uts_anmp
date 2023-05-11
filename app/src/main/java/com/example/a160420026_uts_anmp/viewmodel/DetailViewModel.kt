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

class DetailViewModel (application: Application): AndroidViewModel(application) {
    val booksLD = MutableLiveData<Book>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null


    fun getData(id: Int) {

        queue = Volley.newRequestQueue(getApplication())
        val url =
            "https://raw.githubusercontent.com/justin20123/160420026_uts_anmp/master/books.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                Log.d("showvoley", it)
                val sType = object : TypeToken<ArrayList<Book>>() { }.type
                val result = Gson().fromJson<ArrayList<Book>>(it, sType)
                booksLD.value = result[id]

                Log.d("showvoley", result.toString())


            },
            {
                Log.d("showvoley", it.toString())

            },


            )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

}