package com.example.smartpay.schoolfee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;
import java.util.PropertyResourceBundle;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolHolder> {
    private Context context;
    private ArrayList<SchoolModel> models;

    public SchoolAdapter(Context c, ArrayList<SchoolModel> S) {
        context = c;
        models = S;

    }

    @NonNull
    @Override
    public SchoolHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SchoolAdapter.SchoolHolder(LayoutInflater.from(context).inflate(R.layout.schoolfeehistoryview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolHolder holder, int position) {
        holder.txtSchollName.setText(models.get(position).getSchoolName());
        holder.txtStudentName.setText(models.get(position).getStudentName());
        holder.txtClass.setText(models.get(position).getStudentClass());
        holder.txtBillAmount.setText(models.get(position).getBillAmount());
        holder.txtSchoolFeeDepositor.setText(models.get(position).getSchooldepname());
        holder.txtDepositorNumber.setText(models.get(position).getSchooldepnum());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class SchoolHolder extends RecyclerView.ViewHolder {
        private TextView txtSchollName, txtStudentName, txtClass, txtBillAmount, txtSchoolFeeDepositor, txtDepositorNumber;

        public SchoolHolder(@NonNull View itemView) {
            super(itemView);

            txtSchollName = (TextView) itemView.findViewById(R.id.txtSchoolNameHistory);
            txtStudentName = (TextView) itemView.findViewById(R.id.txtSchoolStudentName);
            txtClass = (TextView) itemView.findViewById(R.id.txtSchoolStudentClass);
            txtBillAmount = (TextView) itemView.findViewById(R.id.txtTxtSchoolStudentFeeAmount);
            txtSchoolFeeDepositor = (TextView) itemView.findViewById(R.id.txtSchoolFeeDepositorName);
            txtDepositorNumber = (TextView) itemView.findViewById(R.id.txtSchoolFeeDepositorNumber);
        }
    }
}
