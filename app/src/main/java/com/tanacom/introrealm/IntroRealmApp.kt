package com.tanacom.introrealm

import android.app.Application
import io.realm.Realm

class IntroRealmApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this);

    }


}