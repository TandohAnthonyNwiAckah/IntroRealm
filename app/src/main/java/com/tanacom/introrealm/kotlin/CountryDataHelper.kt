//package com.tanacom.introrealm.kotlin
//
//import com.tanacom.introrealm.java.CountryModel
//import io.realm.Realm
//
//object CountryDataHelper {
//
//    @JvmStatic
//    fun addCountry(realm: Realm, countryID: Int, countryName: String?) {
//        realm.beginTransaction()
//        val model = realm.createObject(
//            CountryModel::class.java, countryID
//        )
//        model.name = countryName
//        realm.commitTransaction()
//    }
//
//    @JvmStatic
//    fun deleteCountry(realm: Realm, id: Long) {
//        realm.executeTransactionAsync { realm ->
//            val model = realm.where(
//                CountryModel::class.java
//            ).equalTo("id", id).findFirst()
//            model?.deleteFromRealm()
//        }
//    }
//
//
//}