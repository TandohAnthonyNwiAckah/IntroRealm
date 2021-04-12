//package com.tanacom.introrealm.kotlin
//
//import android.os.Bundle
//import android.view.View
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.DialogFragment
//import androidx.recyclerview.widget.DividerItemDecoration
//import androidx.recyclerview.widget.ItemTouchHelper
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.material.floatingactionbutton.FloatingActionButton
//import com.tanacom.introrealm.R
//import com.tanacom.introrealm.kotlin.CountryDataHelper.addCountry
//import com.tanacom.introrealm.kotlin.CountryDataHelper.deleteCountry
//import io.realm.Realm
//import java.security.SecureRandom
//
//class MainActivity : AppCompatActivity(), CountryListener {
//    private var realm: Realm? = null
//    private var recyclerView: RecyclerView? = null
//    private var fab: FloatingActionButton? = null
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        init()
//    }
//
//    private fun init() {
//        realm = Realm.getDefaultInstance()
//        recyclerView = findViewById(R.id.rv)
//        val taskDialog: DialogFragment = CountryDialog()
//        fab = findViewById(R.id.fab)
//        setRecyclerView()
//
//        fab!!.setOnClickListener { view: View? ->
//            taskDialog.show(
//                supportFragmentManager, "New Country"
//            )
//        }
//    }
//
//    override fun onAddCountry(country: String?) {
//        val rand = SecureRandom()
//        // from 0 to 99999
//        val countryID = rand.nextInt(100000)
//        addCountry(realm!!, countryID, country)
//    }
//
//    private fun setRecyclerView() {
//        val adapter = CountryAdapter(
//            realm!!.where(
//                CountryModel::class.java
//            ).findAll()
//        )
//        recyclerView!!.adapter = adapter
//        recyclerView!!.layoutManager = LinearLayoutManager(this)
//        recyclerView!!.addItemDecoration(
//            DividerItemDecoration(
//                this,
//                DividerItemDecoration.HORIZONTAL
//            )
//        )
//        val th = TouchHelperCallback()
//        val ith = ItemTouchHelper(th)
//        ith.attachToRecyclerView(recyclerView)
//    }
//
//    override fun onCancel(dialogFragment: DialogFragment?) {
//        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
//    }
//
//    private inner class TouchHelperCallback : ItemTouchHelper.SimpleCallback(
//        ItemTouchHelper.UP or ItemTouchHelper.DOWN,
//        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
//    ) {
//        override fun onMove(
//            recyclerView: RecyclerView,
//            viewHolder: RecyclerView.ViewHolder,
//            target: RecyclerView.ViewHolder
//        ): Boolean {
//            return false
//        }
//
//        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//            deleteCountry(realm!!, viewHolder.itemId)
//        }
//    }
//
//
//}