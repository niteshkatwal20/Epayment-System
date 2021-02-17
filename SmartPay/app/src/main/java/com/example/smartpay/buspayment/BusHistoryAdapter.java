package com.example.smartpay.buspayment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;

public class BusHistoryAdapter extends RecyclerView.Adapter<BusHistoryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<BusModel> busModelArrayList;

    public BusHistoryAdapter(Context c, ArrayList<BusModel> B) {
        context = c;
        busModelArrayList = B;

    }

    @NonNull
    @Override
    public BusHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.bushistoryview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BusHistoryAdapter.ViewHolder holder, int position) {
        holder.txtBusFrom.setText(busModelArrayList.get(position).getFrom());
        holder.txtBusTo.setText(busModelArrayList.get(position).getTo());
        holder.txtBusPassanger.setText(busModelArrayList.get(position).getPassengername());
        holder.txtBusName.setText(busModelArrayList.get(position).getBusname());
        holder.txtBusTicketNum.setText(busModelArrayList.get(position).getTicketno());
        holder.txtBusPassNum.setText(busModelArrayList.get(position).getPassangerno());
        holder.txtBusFare.setText(busModelArrayList.get(position).getBusfare());
        holder.txtNoofpass.setText(busModelArrayList.get(position).getNoofpassenger());
    }

    @Override
    public int getItemCount() {
        return busModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtBusFrom, txtBusTo, txtBusPassanger, txtBusName, txtBusTicketNum, txtBusPassNum, txtBusFare, txtNoofpass;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBusFrom = (TextView) itemView.findViewById(R.id.txtFrom);
            txtBusTo = (TextView) itemView.findViewById(R.id.txtTo);
            txtBusPassanger = (TextView) itemView.findViewById(R.id.txtPassName);
            txtBusName = (TextView) itemView.findViewById(R.id.txtBusName);
            txtBusTicketNum = (TextView) itemView.findViewById(R.id.txtTicketNo);

            txtBusPassNum = (TextView) itemView.findViewById(R.id.txtPassNo);
            txtBusFare = (TextView) itemView.findViewById(R.id.txtBusFare);
            txtNoofpass = (TextView) itemView.findViewById(R.id.txtNoofpass);
        }
    }
}
