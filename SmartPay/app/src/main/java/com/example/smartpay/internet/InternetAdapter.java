package com.example.smartpay.internet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;

public class InternetAdapter extends RecyclerView.Adapter<InternetAdapter.InternetHolder> {

    private Context context;
    private ArrayList<InternetModel> list;

    public InternetAdapter(Context C, ArrayList<InternetModel> I) {
        context = C;
        list = I;

    }

    @NonNull
    @Override
    public InternetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InternetAdapter.InternetHolder(LayoutInflater.from(context).inflate(R.layout.internethistoryview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InternetHolder holder, int position) {
        holder.txtISPName.setText(list.get(position).getServiceProvider());
        holder.txtCustomerName.setText(list.get(position).getIspClientName());
        holder.txtCustomerID.setText(list.get(position).getIspClientId());
        holder.txtInternetBillAmount.setText(list.get(position).getInternetBillPayment());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class InternetHolder extends RecyclerView.ViewHolder {

        private TextView txtISPName, txtCustomerName, txtCustomerID, txtInternetBillAmount;

        public InternetHolder(@NonNull View itemView) {
            super(itemView);

            txtCustomerID = (TextView) itemView.findViewById(R.id.txtInternetCustomerID);
            txtCustomerName = (TextView) itemView.findViewById(R.id.txtInternetCustomerName);
            txtISPName = (TextView) itemView.findViewById(R.id.txtInternetProviderName);
            txtInternetBillAmount = (TextView) itemView.findViewById(R.id.txtInternetPayment);

        }
    }
}
