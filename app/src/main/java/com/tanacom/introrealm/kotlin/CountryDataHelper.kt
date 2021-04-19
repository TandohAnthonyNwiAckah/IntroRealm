package com.tanacom.introrealm.kotlin

import io.realm.Realm

object CountryDataHelper {

    @JvmStatic
    fun addCountry(realm: Realm, countryName: String?) {


        realm.beginTransaction()

        val maxId = realm.where(CountryModel::class.java).max("id") as Long?

        if (maxId == null) {
            val model = realm.createObject(
                CountryModel::class.java, 0
            )
            model.name = countryName
        } else {
            val model = realm.createObject(
                CountryModel::class.java, maxId + 1
            )
            model.name = countryName
        }

        realm.commitTransaction()

    }

    fun syncCountry(realm: Realm, countryName: String?) {


        realm.beginTransaction()

        val maxId = realm.where(CountryModel::class.java).max("id") as Long?

        if (maxId == null) {
            val model = realm.createObject(
                CountryModel::class.java, 0
            )
            model.name = countryName
        } else {
            val model = realm.createObject(
                CountryModel::class.java, maxId + 1
            )
            model.name = countryName
        }

        realm.commitTransaction()

    }

    @JvmStatic
    fun deleteCountry(realm: Realm, id: Long) {
        realm.executeTransactionAsync { realm ->
            val model = realm.where(
                CountryModel::class.java
            ).equalTo("id", id).findFirst()
            model?.deleteFromRealm()
        }
    }


}