package com.example.a160420026_uts_anmp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.example.a160420026_uts_anmp.model.Profile

class ProfileViewModel (application: Application): AndroidViewModel(application){
    val profileLD = MutableLiveData<Profile>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
}