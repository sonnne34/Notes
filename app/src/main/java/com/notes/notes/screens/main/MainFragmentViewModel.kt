package com.notes.notes.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.notes.notes.utilits.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
    fun signOut(){
        REPOSITORY.signOut()
    }
}