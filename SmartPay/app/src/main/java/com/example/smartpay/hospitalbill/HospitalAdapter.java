package com.example.smartpay.hospitalbill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HospitalHolder> {
    private Context context;
    private ArrayList<HospitalModel> arrayList;

    public HospitalAdapter(Context C, ArrayList<HospitalModel> H) {
        context = C;
        arrayList = H;

    }

    @NonNull
    @Override
    public HospitalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HospitalAdapter.HospitalHolder(LayoutInflater.from(context).inflate(R.layout.hospitalhistoryview, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull HospitalHolder holder, int position) {

        holder.Hospital.setText(arrayList.get(position).getHospitalname());
        holder.PatientName.setText(arrayList.get(position).getPatientname());
        holder.BillNo.setText(arrayList.get(position).getHospitalbillno());
        holder.Amount.setText(arrayList.get(position).getHospitalbillamount());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HospitalHolder extends RecyclerView.ViewHolder {

        private TextView Hospital, PatientName, BillNo, Amount;

        public HospitalHolder(@NonNull View itemView) {
            super(itemView);
            Hospital = (TextView) itemView.findViewById(R.id.txtHospitalName);
            PatientName = (TextView) itemView.findViewById(R.id.txtPatientName);
            BillNo = (TextView) itemView.findViewById(R.id.txtBillNo);
            Amount = (TextView) itemView.findViewById(R.id.txtHospitalAmount);

        }
    }
}
