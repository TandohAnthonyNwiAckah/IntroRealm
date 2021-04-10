# IntroRealm
Introduction to Realm Database in Android.

Realm’s mobile database is an open source, developer-friendly alternative to CoreData and SQLite.

It is essentially a noSQL database which means that with Realm, you can store and retrieve data that is modeled in means other than tabular relations of relational databases.



## Getting Started


-  Add the classpath dependency in your project level build.gradle in either your existing project or newly created project

```
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    ext.realm_version = "6.0.2"
    ext.gradle_version = "4.1.3"
    ext.kotlin_version = "1.4.32"

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath "com.android.tools.build:gradle:$gradle_version"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        classpath "io.realm:realm-gradle-plugin:$realm_version"
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

```



-   Add the realm-android plugin at the top of your application level build.gradle . 
If your application uses the Kotlin programming language, you need to apply the kotlin-kapt plugin:

```

plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
    id 'realm-android'
}



```



- Initialize the Realm App in your base Application.

```

class IntroRealmApp : Application() {

    override fun onCreate() {
        super.onCreate()
        
        Realm.init(this)
    }


}



```


- Add your application name to the AndroidManifest

```

<application
   android:name=".IntroRealmApp"
   ...
/>

```
