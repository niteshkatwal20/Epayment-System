package com.example.smartpay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;
import com.example.smartpay.databse.SendMoneyData;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    Context context;
    ArrayList<SendMoneyData> sendmoneydata;

    public TransactionAdapter(Context c, ArrayList<SendMoneyData> h) {
        context = c;
        sendmoneydata = h;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtEmail.setText(sendmoneydata.get(position).getSendEmail());
        holder.txtAmount.setText(sendmoneydata.get(position).getSendAmount());
        holder.txtPurpose.setText(sendmoneydata.get(position).getPurpose());
        holder.txtRemarks.setText(sendmoneydata.get(position).getRemarks());
    }

    @Override
    public int getItemCount() {
        return sendmoneydata.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtEmail, txtAmount, txtPurpose, txtRemarks;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEmail = (TextView) itemView.findViewById(R.id.txtEmail);
            txtAmount = (TextView) itemView.findViewById(R.id.txtAmount);
            txtPurpose = (TextView) itemView.findViewById(R.id.txtPurpose);
            txtRemarks = (TextView) itemView.findViewById(R.id.txtRemarks);
        }
    }

}
