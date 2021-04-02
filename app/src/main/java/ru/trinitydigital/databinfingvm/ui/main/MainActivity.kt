package ru.trinitydigital.databinfingvm.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.trinitydigital.databinfingvm.BR
import ru.trinitydigital.databinfingvm.R
import ru.trinitydigital.databinfingvm.common.SimpleBindingRvAdapter
import ru.trinitydigital.databinfingvm.data.model.SampleModel
import ru.trinitydigital.databinfingvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()
    private var binding: ActivityMainBinding? = null
    private val adapter by lazy { SimpleBindingRvAdapter<SampleModel>(R.layout.item_sample, BR.data) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding?.root)
        binding?.lifecycleOwner = this
        binding?.setVariable(BR.vm, vm)
        binding?.recycler?.adapter = adapter
        vm.generateList()
        dbFirebase()
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
}