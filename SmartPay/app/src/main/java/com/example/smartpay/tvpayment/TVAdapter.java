package com.example.smartpay.tvpayment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;


public class TVAdapter extends RecyclerView.Adapter<TVAdapter.TVHolder> {
    private Context context;
    private ArrayList<TvModel> tvModels;

    public TVAdapter(Context c, ArrayList<TvModel> a) {
        context = c;
        tvModels = a;

    }

    @NonNull
    @Override
    public TVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TVAdapter.TVHolder(LayoutInflater.from(context).inflate(R.layout.tvhistoryview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TVHolder holder, int position) {
        holder.DepositorName.setText(tvModels.get(position).getTvDepositername());
        holder.DepositorNumber.setText(tvModels.get(position).getTvDepositorNo());
        holder.CustomerName.setText(tvModels.get(position).getCustomerName());
        holder.CustomerId.setText(tvModels.get(position).getCustomerId());
        holder.PayAmount.setText(tvModels.get(position).getTvamount());
    }

    @Override
    public int getItemCount() {
        return tvModels.size();
    }

    public class TVHolder extends RecyclerView.ViewHolder {

        private TextView CustomerName, CustomerId, PayAmount, DepositorName, DepositorNumber;

        public TVHolder(@NonNull View itemView) {
            super(itemView);
            CustomerName = (TextView) itemView.findViewById(R.id.txtTvCustomerName);
            CustomerId = (TextView) itemView.findViewById(R.id.txtTvCustomerID);
            PayAmount = (TextView) itemView.findViewById(R.id.txtTvBillPayment);
            DepositorName = (TextView) itemView.findViewById(R.id.txtTvBillDepositorName);
            DepositorNumber = (TextView) itemView.findViewById(R.id.txtTvBillFeeDepositorNumber);

        }
    }
}
