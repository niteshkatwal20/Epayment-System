package com.example.smartpay.flightpayment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.FlightHolder> {

    private Context context;
    private ArrayList<FlightModel> arrayList;

    public FlightAdapter(Context c, ArrayList<FlightModel> F) {
        context = c;
        arrayList = F;

    }

    @NonNull
    @Override
    public FlightHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlightAdapter.FlightHolder(LayoutInflater.from(context).inflate(R.layout.flighthistoryview, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull FlightHolder holder, int position) {
        holder.FlightForm.setText(arrayList.get(position).getFlightFrom());
        holder.FlightTo.setText(arrayList.get(position).getFlightTo());
        holder.FlightPassengerName.setText(arrayList.get(position).getFlightPassangerName());
        holder.FlightNoOfPass.setText(arrayList.get(position).getFlightNoofPass());
        holder.FlightName.setText(arrayList.get(position).getFlightNo());
        holder.FlightTicketNo.setText(arrayList.get(position).getFlightTicketNo());
        holder.FlightDate.setText(arrayList.get(position).getFlightDate());
        holder.FlightPassNo.setText(arrayList.get(position).getfLightPassangerNo());
        holder.FlightTicketFare.setText(arrayList.get(position).getFlightAmount());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class FlightHolder extends RecyclerView.ViewHolder {

        TextView FlightForm, FlightTo, FlightPassengerName, FlightNoOfPass;
        TextView FlightName, FlightTicketNo, FlightDate, FlightPassNo, FlightTicketFare;

        public FlightHolder(@NonNull View itemView) {
            super(itemView);
            FlightForm = (TextView) itemView.findViewById(R.id.txtFlightFrom);
            FlightTo = (TextView) itemView.findViewById(R.id.txtFlightTo);
            FlightPassengerName = (TextView) itemView.findViewById(R.id.txtFlightPassName);
            FlightNoOfPass = (TextView) itemView.findViewById(R.id.txtFlightNoofpass);
            FlightName = (TextView) itemView.findViewById(R.id.txtFlightName);
            FlightTicketNo = (TextView) itemView.findViewById(R.id.txtFlightTicketNo);
            FlightDate = (TextView) itemView.findViewById(R.id.txtFlightDate);
            FlightPassNo = (TextView) itemView.findViewById(R.id.txtFlightPassNo);
            FlightTicketFare = (TextView) itemView.findViewById(R.id.txtFlightFare);


        }
    }
}
