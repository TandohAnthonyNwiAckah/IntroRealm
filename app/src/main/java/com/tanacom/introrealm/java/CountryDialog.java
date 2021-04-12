package com.tanacom.introrealm.java;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.tanacom.introrealm.R;

import java.util.Objects;

public class CountryDialog extends DialogFragment {

    CountryListener listerner;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater = getActivity().getLayoutInflater();

        final View dialogLay = inflater.inflate(R.layout.country_dialog, null, true);

        final EditText editText = dialogLay.findViewById(R.id.et_country);

        builder.setView(dialogLay)
                .setPositiveButton(
                        "Add Country", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String country = editText.getText().toString();

                                listerner.onAddCountry(country);

                            }
                        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Objects.requireNonNull(CountryDialog.this.getDialog()).cancel();
                                listerner.onCancel(CountryDialog.this);
                            }

                        }

                );

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listerner = (CountryListener) context;
        } catch (ClassCastException e) {

            throw new ClassCastException(getActivity().toString() + "must implement interface");
        }


    }


}

