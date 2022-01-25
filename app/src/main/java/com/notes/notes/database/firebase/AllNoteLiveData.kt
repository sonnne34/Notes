package com.notes.notes.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.notes.notes.models.AppNote
import com.notes.notes.utilits.REF_DATABASE
import com.notes.notes.utilits.log


class AllNoteLiveData : LiveData<List<AppNote>>() {

    private val listener = object : ValueEventListener {

        override fun onDataChange(snapshot: DataSnapshot) {
            value = snapshot.children.map {
                log(" value = snapshot.children.map")
                it.getValue(AppNote::class.java) ?: AppNote()
            }
            log("onDataChange")
        }

        override fun onCancelled(error: DatabaseError) {

        }
    }

    override fun onActive() {
        REF_DATABASE.addValueEventListener(listener)
        log("onActive")
        super.onActive()
    }

    override fun onInactive() {
        REF_DATABASE.removeEventListener(listener)
        log("noActive")
        super.onInactive()
    }
}