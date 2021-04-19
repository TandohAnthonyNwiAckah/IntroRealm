package com.tanacom.introrealm.kotlin

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.tanacom.introrealm.R
import com.tanacom.introrealm.kotlin.Constants.ADD_COUNTRY
import com.tanacom.introrealm.kotlin.Constants.CANCEL
import java.util.*

class CountryDialog : DialogFragment() {

    var listerner: CountryListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)
        val inflater = activity!!.layoutInflater
        val dialogLay = inflater.inflate(R.layout.country_dialog, null, true)
        val editText = dialogLay.findViewById<EditText>(R.id.et_country)
        builder.setView(dialogLay)
            .setPositiveButton(
                ADD_COUNTRY
            ) { _, i ->
                val country = editText.text.toString()
                listerner!!.onAddCountry(country)
            }

//            .setNeutralButton("Sync") { _, _ ->
//                listerner!!.onSync()
//            }

            .setNegativeButton(
                CANCEL
            ) { _, i ->
                Objects.requireNonNull(this@CountryDialog.dialog)!!.cancel()
                listerner!!.onCancel(this@CountryDialog)
            }
        return builder.create()
    }

    override fun onAttach(context: Context) {

        super.onAttach(context)
        listerner = try {
            context as CountryListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + "must implement interface")
        }
    }


}