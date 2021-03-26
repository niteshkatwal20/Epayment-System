package com.example.smartpay.recharge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;

public class RechargeAdapter extends RecyclerView.Adapter<RechargeAdapter.RechargeHolder> {
    private Context context;
    private ArrayList<RechargeModel> rechargeModels;

    public RechargeAdapter(Context C, ArrayList<RechargeModel> arrayList) {
        context = C;
        rechargeModels = arrayList;

    }

    @NonNull
    @Override
    public RechargeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RechargeAdapter.RechargeHolder(LayoutInflater.from(context).inflate(R.layout.rechargehistoryview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RechargeHolder holder, int position) {
        holder.txtMobileNumber.setText(rechargeModels.get(position).getRechargeMobileNo());
        holder.txtRechargeAmount.setText(rechargeModels.get(position).getRechageAmount());
    }

    @Override
    public int getItemCount() {
        return rechargeModels.size();
    }

    public class RechargeHolder extends RecyclerView.ViewHolder {

        private TextView txtMobileNumber, txtRechargeAmount;

        public RechargeHolder(@NonNull View itemView) {
            super(itemView);
            txtMobileNumber = (TextView) itemView.findViewById(R.id.txtRechargeMobileNumber);
            txtRechargeAmount = (TextView) itemView.findViewById(R.id.txtRechargeMobileAmount);

        }
    }
}
