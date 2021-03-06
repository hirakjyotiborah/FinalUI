package com.deskneed.team.RideTrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deskneed.team.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private Context context;
    private List<TripData> tripData;
    private NotesAdapter.OnItemClickListener mListener;



    public interface OnItemClickListener{
        void onItemClick(int position);
        void onUpdateClick(int position);
    }

    public void setOnItemClickListener(NotesAdapter.OnItemClickListener listener){
        mListener = listener;
    }


    public NotesAdapter(Context context, List<TripData> tripData) {
        this.context = context;
        this.tripData = tripData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.note_list_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        TripData note = tripData.get(position);

        holder.name.setText(note.getName());
        holder.dis.setText(String.valueOf(note.getDistance()));
        holder.dur.setText(note.getDuration());
    }

    @Override
    public int getItemCount() {
        return tripData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView dis;
        TextView dur;

        public MyViewHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.name);
            dis = view.findViewById(R.id.dis);
            dur = view.findViewById(R.id.dur);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int pos  = getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            mListener.onUpdateClick(pos);
                        }
                    }
                }
            });
        }
    }
}