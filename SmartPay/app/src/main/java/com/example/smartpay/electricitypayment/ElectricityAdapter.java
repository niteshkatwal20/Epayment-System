package com.example.smartpay.electricitypayment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;
import com.example.smartpay.banktransfer.BankTransferAdapter;

import java.util.ArrayList;

public class ElectricityAdapter extends RecyclerView.Adapter<ElectricityAdapter.ElectricityHolder> {

    private Context context;
    private ArrayList<ElectricityModel> modelArrayList;

    public ElectricityAdapter(Context c, ArrayList<ElectricityModel> E) {
        context = c;
        modelArrayList = E;

    }

    @NonNull
    @Override
    public ElectricityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ElectricityAdapter.ElectricityHolder(LayoutInflater.from(context).inflate(R.layout.electricityistoryview, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ElectricityHolder holder, int position) {
        holder.DepositorName.setText(modelArrayList.get(position).getEleDepositerName());
        holder.DepositorNumber.setText(modelArrayList.get(position).getEleDepositerNumber());
        holder.CustomerName.setText(modelArrayList.get(position).getEleCustomerName());
        holder.CustomerID.setText(modelArrayList.get(position).geteLeCustomerId());
        holder.Amount.setText(modelArrayList.get(position).getEleAmount());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ElectricityHolder extends RecyclerView.ViewHolder {
        TextView CustomerName, CustomerID, Amount, DepositorName, DepositorNumber;

        public ElectricityHolder(@NonNull View itemView) {
            super(itemView);
            CustomerName = (TextView) itemView.findViewById(R.id.txtCustomerNameElec);
            CustomerID = (TextView) itemView.findViewById(R.id.txtCustomerIdElec);
            Amount = (TextView) itemView.findViewById(R.id.txtAmountElec);
            DepositorName = (TextView) itemView.findViewById(R.id.txtDepNameElec);
            DepositorNumber = (TextView) itemView.findViewById(R.id.txtDepNumberElec);

        }
    }

}
