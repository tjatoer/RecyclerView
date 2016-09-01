package com.sekawan.studio.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context mContext;
    private List<Data> phoneList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Data phone = phoneList.get(getAdapterPosition());
                        Toast.makeText(v.getContext(), "position = " + getAdapterPosition()+"   "+phone.getName(), Toast.LENGTH_SHORT).show();
                    Log.i("Test Posisi klik coy", "Element " + getAdapterPosition() + " clicked.");
                }
            });
        }

    }


    public MainAdapter(Context mContext, List<Data> albumList) {
        this.mContext = mContext;
        this.phoneList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Data phone = phoneList.get(position);
        holder.title.setText(phone.getName());

        // loading album cover using Glide library
        Glide.with(mContext).load(phone.getThumbnail()).into(holder.thumbnail);


    }




    @Override
    public int getItemCount() {
        return phoneList.size();
    }
    void Toast(){
        //Toast.makeText(this,"tes",Toast.LENGTH_LONG).show();
    }
}
