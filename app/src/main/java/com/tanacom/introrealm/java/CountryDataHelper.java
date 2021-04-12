package com.tanacom.introrealm.java;

import io.realm.Realm;

public class CountryDataHelper {

    public static void addCountry(Realm realm, int countryID, String countryName) {
        realm.beginTransaction();
        CountryModel model = realm.createObject(CountryModel.class, countryID);
        model.setName(countryName);
        realm.commitTransaction();
    }

    public static void deleteCountry(Realm realm, long id) {
        realm.executeTransactionAsync(
                new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        CountryModel model = realm.where(CountryModel.class).equalTo("id", id).findFirst();
                        if (model != null) {
                            model.deleteFromRealm();
                        }
                    }
                }
        );
    }

}
