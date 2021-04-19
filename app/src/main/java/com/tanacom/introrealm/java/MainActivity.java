//package com.tanacom.introrealm.java;
//
//import android.os.Bundle;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.DialogFragment;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.ItemTouchHelper;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.tanacom.introrealm.R;
//
//import io.realm.Realm;
//
//public class MainActivity extends AppCompatActivity implements CountryListener {
//
//
//    private Realm realm;
//    private RecyclerView recyclerView;
//    private FloatingActionButton fab;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_main);
//
//        init();
//    }
//
//    private void init() {
//
//        realm = Realm.getDefaultInstance();
//
//        recyclerView = findViewById(R.id.rv);
//
//        DialogFragment taskDialog = new CountryDialog();
//
//        fab = findViewById(R.id.fab);
//
//        setRecyclerView();
//
//        fab.setOnClickListener(
//                view -> {
//                    taskDialog.show(getSupportFragmentManager(), "New Country");
//
//                }
//        );
//
//
//    }
//
//    @Override
//    public void onAddCountry(String country) {
////
////        SecureRandom rand = new SecureRandom();
////        // from 0 to 99999
////        int countryID = rand.nextInt(100000);
////
////        CountryDataHelper.addCountry(realm, countryID, country);
//
//        CountryDataHelper.addCountry(realm, country);
//
//    }
//
//    private void setRecyclerView() {
//
//        CountryAdapter adapter = new CountryAdapter(realm.where(CountryModel.class).findAll());
//
//        recyclerView.setAdapter(adapter);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
//
//        TouchHelperCallback th = new TouchHelperCallback();
//
//        ItemTouchHelper ith = new ItemTouchHelper(th);
//
//        ith.attachToRecyclerView(recyclerView);
//
//    }
//
//    @Override
//    public void onCancel(DialogFragment dialogFragment) {
//
//        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
//
//    }
//
//    private class TouchHelperCallback extends ItemTouchHelper.SimpleCallback {
//
//        public TouchHelperCallback() {
//
//            super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
//
//        }
//
//        @Override
//        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//            return false;
//        }
//
//        @Override
//        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//
//            CountryDataHelper.deleteCountry(realm, viewHolder.getItemId());
//
//        }
//
//    }
//
//
//}
