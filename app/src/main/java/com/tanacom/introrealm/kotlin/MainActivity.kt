package com.tanacom.introrealm.kotlin

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tanacom.introrealm.R
import com.tanacom.introrealm.kotlin.Constants.ACCEPT
import com.tanacom.introrealm.kotlin.Constants.AUTHORIZATION
import com.tanacom.introrealm.kotlin.Constants.ENDPOINTS
import com.tanacom.introrealm.kotlin.Constants.TAGG
import com.tanacom.introrealm.kotlin.CountryDataHelper.addCountry
import com.tanacom.introrealm.kotlin.CountryDataHelper.deleteCountry
import com.tanacom.introrealm.kotlin.CountryDataHelper.syncCountry
import io.realm.Realm
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity(), CountryListener {
    private var realm: Realm? = null
    private var recyclerView: RecyclerView? = null
    private var fab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        realm = Realm.getDefaultInstance()
        recyclerView = findViewById(R.id.rv)
        val taskDialog: DialogFragment = CountryDialog()
        fab = findViewById(R.id.fab)
        setRecyclerView()

        fab!!.setOnClickListener { view: View? ->
            taskDialog.show(
                supportFragmentManager, TAGG
            )
        }


    }

    private fun setRecyclerView() {
        val adapter = CountryAdapter(
            realm!!.where(
                CountryModel::class.java
            ).findAll()
        )
        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        recyclerView!!.adapter!!.notifyDataSetChanged()

        val th = TouchHelperCallback()
        val ith = ItemTouchHelper(th)
        ith.attachToRecyclerView(recyclerView)
    }

    override fun onAddCountry(country: String?) {
        addCountry(realm!!, country)

    }

    override fun onCancel(dialogFragment: DialogFragment?) {
        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
    }

    override fun onSync() {
        getCountries()

    }

    private fun getCountries() {
        val queue = Volley.newRequestQueue(this)

        val url = ENDPOINTS

        val getRequest: StringRequest = object : StringRequest(
            Method.GET, url,
            Response.Listener<String?> { response -> // response
                Log.d("Response", response)

                handleResponse(response)
            },

            Response.ErrorListener { error ->
                Log.d("ERROR", "error => $error")
                Toast.makeText(
                    applicationContext,
                    "Try Again",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["Authorization"] = AUTHORIZATION
                params["Accept"] = ACCEPT
                return params
            }
        }
        queue.add(getRequest)
    }

    private fun handleResponse(response: String) {
        val jsonArray = JSONArray(response)
        for (i in 0 until jsonArray.length()) {
            val jsonObject: JSONObject = jsonArray[i] as JSONObject

            syncCountry(realm!!, jsonObject.getString("country_name"))

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater

        inflater.inflate(R.menu.menu, menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sync -> {
                getCountries()
                true

            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private inner class TouchHelperCallback : ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN,
        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            deleteCountry(realm!!, viewHolder.itemId)
        }
    }


}