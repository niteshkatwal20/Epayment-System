package com.example.smartpay.banktransfer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;

public class BankTransferAdapter extends RecyclerView.Adapter<BankTransferAdapter.BankHolder> {

    private Context context;
    private ArrayList<BankTransferModel> data;

    public BankTransferAdapter(Context c, ArrayList<BankTransferModel> b) {
        context = c;
        data = b;

    }

    @NonNull
    @Override
    public BankHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BankTransferAdapter.BankHolder(LayoutInflater.from(context).inflate(R.layout.banktransfercardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BankHolder holder, int position) {
        holder.BankName.setText(data.get(position).getBankname());
        holder.BankAccountNo.setText(data.get(position).getBankaccountno());
        holder.BankAmount.setText(data.get(position).getBankamount());
        holder.BankDepositorName.setText(data.get(position).getBankdepositername());
        holder.BankDepositorNo.setText(data.get(position).getBankdepositernumber());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class BankHolder extends RecyclerView.ViewHolder {

        TextView BankName, BankAccountNo, BankAmount, BankDepositorName, BankDepositorNo;

        public BankHolder(@NonNull View itemView) {
            super(itemView);

            BankName = (TextView) itemView.findViewById(R.id.txtBankTransferBankNameHis);
            BankAccountNo = (TextView) itemView.findViewById(R.id.txtBankTransferAccNoHis);
            BankAmount = (TextView) itemView.findViewById(R.id.txtBankTransferAmountHis);
            BankDepositorName = (TextView) itemView.findViewById(R.id.txtBankTransDepNameHis);
            BankDepositorNo = (TextView) itemView.findViewById(R.id.txtBankTransDepNoHis);
        }
    }


}
