package com.example.smartpay.hotelpayment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;


public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelHolder> {

    private Context context;
    private ArrayList<HotelModel> modelHotel;

    public HotelAdapter(Context C, ArrayList<HotelModel> Ho) {
        context = C;
        modelHotel = Ho;

    }

    @NonNull
    @Override
    public HotelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HotelAdapter.HotelHolder(LayoutInflater.from(context).inflate(R.layout.hotelhistoryview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HotelHolder holder, int position) {
        holder.HotelName.setText(modelHotel.get(position).getHotelName());
        holder.GuestName.setText(modelHotel.get(position).getGuestName());
        holder.HotelBillAmount.setText(modelHotel.get(position).getHotelBillamount());
        holder.HotelBillNo.setText(modelHotel.get(position).getHotelBillno());
        holder.RoomNo.setText(modelHotel.get(position).getRoomNo());
        holder.HotelNoOfGuest.setText(modelHotel.get(position).getNoOfperson());
        holder.HotelGuestMoNumber.setText(modelHotel.get(position).getGuestNumber());
    }

    @Override
    public int getItemCount() {
        return modelHotel.size();
    }

    public class HotelHolder extends RecyclerView.ViewHolder {

        TextView HotelName, GuestName, HotelBillAmount, HotelBillNo, RoomNo, HotelNoOfGuest, HotelGuestMoNumber;

        public HotelHolder(@NonNull View itemView) {
            super(itemView);

            HotelName = (TextView) itemView.findViewById(R.id.txtHotelName);
            GuestName = (TextView) itemView.findViewById(R.id.txtBookingName);
            HotelBillAmount = (TextView) itemView.findViewById(R.id.txtHotelFare);
            HotelBillNo = (TextView) itemView.findViewById(R.id.txtHotelBillNo);
            RoomNo = (TextView) itemView.findViewById(R.id.txtHotelRoomNo);
            HotelNoOfGuest = (TextView) itemView.findViewById(R.id.txtHotelNoOfPer);
            HotelGuestMoNumber = (TextView) itemView.findViewById(R.id.txtHotelGuestNumber);

        }
    }
}
