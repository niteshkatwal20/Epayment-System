package com.example.smartpay.AddMoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;

public class AddMoneyAdapter extends RecyclerView.Adapter<AddMoneyAdapter.MyHolder> {

    private Context context;

    private ArrayList<AddMoneyModel> addMoneyData;

    public AddMoneyAdapter(Context c, ArrayList<AddMoneyModel> a) {
        context = c;
        addMoneyData = a;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.recivemoneycardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.txtAddMoneyHistoryBankName.setText(addMoneyData.get(position).getAddMoneyBankname());
        holder.txtAddMoneyHistoryAccNo.setText(addMoneyData.get(position).getAddMoneyAccount());
        holder.txtAddMoneyHistoryAmount.setText(addMoneyData.get(position).getAddMoneyAmount());
        holder.txtAddMoneyHistoryRemarks.setText(addMoneyData.get(position).getAddMoneyRemarks());
    }

    @Override
    public int getItemCount() {
        return addMoneyData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtAddMoneyHistoryBankName, txtAddMoneyHistoryAccNo, txtAddMoneyHistoryAmount, txtAddMoneyHistoryRemarks;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            txtAddMoneyHistoryBankName = (TextView) itemView.findViewById(R.id.txtBankNameAddMoneyHistory);
            txtAddMoneyHistoryAccNo = (TextView) itemView.findViewById(R.id.txtAccountAddMoneyHistory);
            txtAddMoneyHistoryAmount = (TextView) itemView.findViewById(R.id.txtAmountHistoryMoneyAdd);
            txtAddMoneyHistoryRemarks = (TextView) itemView.findViewById(R.id.txtRemarksHistoryAddMoney);
        }
    }
}
