package com.example.maehendra14.pesonamalangraya.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.maehendra14.pesonamalangraya.R;
import com.example.maehendra14.pesonamalangraya.model.Fasilitas;

import java.util.List;

public class FasilitasAdapter extends RecyclerView.Adapter<FasilitasAdapter.MyViewHolder> {

    private List<Fasilitas> mFasilities;
    private Context mContext;

    public FasilitasAdapter(List<Fasilitas> fasilitasList, Context context) {
        mFasilities = fasilitasList;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item_fasilitas,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Fasilitas temp = mFasilities.get(position);
        Glide.with(mContext).load(temp.getImageId()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mFasilities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_fasilitas);
        }
    }
}
