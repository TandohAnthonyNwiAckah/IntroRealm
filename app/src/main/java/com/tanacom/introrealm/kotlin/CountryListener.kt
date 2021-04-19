package com.tanacom.introrealm.kotlin

import androidx.fragment.app.DialogFragment

interface CountryListener {

    fun onAddCountry(task: String?)

    fun onCancel(dialogFragment: DialogFragment?)

}