package com.example.smartpay.landline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;

public class LandlineAdapter extends RecyclerView.Adapter<LandlineAdapter.LandLineHolder> {

    private Context context;
    private ArrayList<LandlineModel> landlineModelList;

    public LandlineAdapter(Context C, ArrayList<LandlineModel> L) {
        context = C;
        landlineModelList = L;

    }

    @NonNull
    @Override
    public LandLineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LandlineAdapter.LandLineHolder(LayoutInflater.from(context).inflate(R.layout.landlinehistoryview, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull LandLineHolder holder, int position) {

        holder.txtServiceProvide.setText(landlineModelList.get(position).getLandLineProvider());
        holder.txtCustomerName.setText(landlineModelList.get(position).getLandLineClientName());
        holder.txtCustomerId.setText(landlineModelList.get(position).getLandLineClientId());
        holder.txtLandlineAmount.setText(landlineModelList.get(position).getLandLineClientId());
    }

    @Override
    public int getItemCount() {
        return landlineModelList.size();
    }

    public class LandLineHolder extends RecyclerView.ViewHolder {
        private TextView txtServiceProvide, txtCustomerName, txtCustomerId, txtLandlineAmount;

        public LandLineHolder(@NonNull View itemView) {
            super(itemView);

            txtServiceProvide = (TextView) itemView.findViewById(R.id.txtLandLineProvide);
            txtCustomerName = (TextView) itemView.findViewById(R.id.txtLandLineUserName);
            txtCustomerId = (TextView) itemView.findViewById(R.id.txtLandLineUserID);
            txtLandlineAmount = (TextView) itemView.findViewById(R.id.txtLandLinePayment);

        }
    }
}
