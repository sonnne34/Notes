package com.notes.notes.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.notes.notes.database.firebase.AppFirebaseRepository
import com.notes.notes.database.room.AppRoomDatabase
import com.notes.notes.database.room.AppRoomRepository
import com.notes.notes.utilits.*

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

    fun initDataBase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({ onSuccess() }, { showToast(it) })
                log("onDataChange")
            }
        }
    }
}