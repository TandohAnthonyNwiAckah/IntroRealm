package com.tanacom.introrealm.java;

import androidx.fragment.app.DialogFragment;

public interface CountryListener {

    void onAddCountry(String task);

    void onCancel(DialogFragment dialogFragment);

}
