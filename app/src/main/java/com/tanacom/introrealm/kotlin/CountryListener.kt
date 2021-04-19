package com.tanacom.introrealm.kotlin

import androidx.fragment.app.DialogFragment

interface CountryListener {

    fun onAddCountry(country: String?)

    fun onCancel(dialogFragment: DialogFragment?)

    fun onSync()


}