//package com.tanacom.introrealm.java;
//
//import com.tanacom.introrealm.kotlin.CountryModel;
//
//import io.realm.Realm;
//
//public class CountryDataHelper {
//
//    public static void addCountry(Realm realm, String countryName) {
//
//        realm.beginTransaction();
//
//        Long maxId = (Long) realm.where(CountryModel.class).max("id");
//
//        if (maxId == null) {
//            CountryModel model = realm.createObject(CountryModel.class, 0);
//            model.setName(countryName);
//        } else {
//            CountryModel model = realm.createObject(CountryModel.class, (maxId + 1));
//            model.setName(countryName);
//
//        }
//
//        realm.commitTransaction();
//
//
//    }
//
//    public static void deleteCountry(Realm realm, long id) {
//        realm.executeTransactionAsync(
//                new Realm.Transaction() {
//                    @Override
//                    public void execute(Realm realm) {
//                        CountryModel model = realm.where(CountryModel.class).equalTo("id", id).findFirst();
//                        if (model != null) {
//                            model.deleteFromRealm();
//                        }
//                    }
//                }
//        );
//    }
//
//
//
//}
