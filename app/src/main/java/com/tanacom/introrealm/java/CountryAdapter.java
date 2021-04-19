//package com.tanacom.introrealm.java;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.tanacom.introrealm.R;
//import com.tanacom.introrealm.kotlin.CountryModel;
//
//import io.realm.OrderedRealmCollection;
//import io.realm.RealmRecyclerViewAdapter;
//
//public class CountryAdapter extends RealmRecyclerViewAdapter<CountryModel, CountryAdapter.MyViewHolder> {
//
//    public CountryAdapter(@Nullable OrderedRealmCollection<CountryModel> data) {
//        super(data, true);
//
//        // Used when there's primary key in Model
//        setHasStableIds(true);
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//
//        final CountryModel model = getItem(position);
//
//        holder.tvCountry.setText(model.getName());
//
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return getItem(position).getId();
//    }
//
//    static class MyViewHolder extends RecyclerView.ViewHolder {
//
//        TextView tvCountry;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            tvCountry = itemView.findViewById(R.id.tv_item);
//        }
//    }
//
//
//}
