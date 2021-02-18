package com.example.smartpay.Movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartpay.R;

import java.util.ArrayList;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private Context context;
    private ArrayList<MovieModel> movieModels;

    public MovieAdapter(Context c, ArrayList<MovieModel> M) {
        context = c;
        movieModels = M;

    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieAdapter.MovieHolder(LayoutInflater.from(context).inflate(R.layout.moviehistoryview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.HallName.setText(movieModels.get(position).getHallName());
        holder.MovieName.setText(movieModels.get(position).getMovieName());
        holder.BookingName.setText(movieModels.get(position).getCustomerName());
        holder.SeatNo.setText(movieModels.get(position).getNoofSeats());
        holder.TicketAmount.setText(movieModels.get(position).getMovieTicketAmount());

    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        TextView HallName, MovieName, BookingName, SeatNo, TicketAmount;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            HallName = (TextView) itemView.findViewById(R.id.txtMovieHallName);
            MovieName = (TextView) itemView.findViewById(R.id.txtMovieNameHistory);
            BookingName = (TextView) itemView.findViewById(R.id.txtMovieBookingName);
            SeatNo = (TextView) itemView.findViewById(R.id.txtMovieSeatNoBook);
            TicketAmount = (TextView) itemView.findViewById(R.id.txtMoviePaymentAmount);
        }
    }
}
