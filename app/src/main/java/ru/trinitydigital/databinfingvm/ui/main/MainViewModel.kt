package ru.trinitydigital.databinfingvm.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import ru.trinitydigital.databinfingvm.data.model.SampleModel
import java.util.*
import kotlin.random.Random

class MainViewModel : ViewModel() {

    val data = MutableLiveData<List<SampleModel>>()

    init {

    }

    fun dbFirebase(){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReferenceFromUrl("https://sambo-test-json-default-rtdb.europe-west1.firebasedatabase.app/")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d("asdasdsad", "Value is: ")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("adasdasdasd", "Failed to read value.", error.toException())
            }
        })
    }

    fun generateList() {
//        dbFirebase()
        val list = arrayListOf<SampleModel>()
        for (i in 0..40) {
            list.add(SampleModel("title is $i", "desc is $i"))
        }
        data.postValue(list)
    }

    fun refreshList() {
        val list = arrayListOf<SampleModel>()
        val int = Random.nextInt(0, 20)
        for (i in 0..int) {
            list.add(SampleModel("title is $i", "desc is $i"))
        }
        data.postValue(list)
    }
}