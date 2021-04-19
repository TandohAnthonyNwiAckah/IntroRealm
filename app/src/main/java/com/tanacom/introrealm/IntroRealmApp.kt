package com.tanacom.introrealm

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

//import com.tanacom.introrealm.java.IntroRealmModel
//import io.realm.RealmQuery
//import io.realm.RealmResults

class IntroRealmApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        val config = RealmConfiguration.Builder()
            .name("country.realm").build()

        Realm.setDefaultConfiguration(config)


//        TUTORIALS
//        val realm = Realm.getDefaultInstance()
//
//        // Insert Value to Realm DB  --- Approach One
//        realm.beginTransaction()
//        val model: IntroRealmModel = realm.createObject(IntroRealmModel::class.java)
//        model.name = "TANACOM"
//        model.age = 100
//        realm.commitTransaction()
//
//        // Insert Value to Realm DB  --- Approach Two
//        // val mod = IntroRealmModel("TANACOM LIMITED",120)
//        // realm.beginTransaction()
//        // realm.copyToRealm(mod)
//        //realm.commitTransaction()
//
//
//        // Query Realm DB
//        val user: RealmQuery<IntroRealmModel> = realm.where(IntroRealmModel::class.java)
//
//        //Query Condition
//        user.equalTo("name", "TANACOM")
//        user.or().equalTo("name", "TANACOM")
//
//
//        // Execute the Query
//        val results: RealmResults<IntroRealmModel> = user.findAll()
//        results[0]!!.age
//        results.size


//
//        executeTransaction()
//       is equivalent to
//
//        try {
//            realm.beginTransaction();
//            // body of executeTransaction
//            realm.commitTransaction();
//        } catch(Exception e) {
//            if(realm.isInTransaction()) {
//                realm.cancelTransaction();
//            }
//            throw new RuntimeException(e);
//        }


    }


}