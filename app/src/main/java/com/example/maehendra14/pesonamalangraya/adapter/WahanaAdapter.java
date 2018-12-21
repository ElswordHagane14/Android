package com.example.maehendra14.pesonamalangraya.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.maehendra14.pesonamalangraya.R;
import com.example.maehendra14.pesonamalangraya.model.Wahana;

import java.util.List;

public class WahanaAdapter extends RecyclerView.Adapter<WahanaAdapter.MyViewHolder> {

    private List<Wahana> mWahana;
    private Context mContext;

    public WahanaAdapter(List<Wahana> wahanaList, Context context) {
        mWahana = wahanaList;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item_wahana,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Wahana temp = mWahana.get(position);
        holder.textView.setText(mWahana.get(position).getText());
        holder.textView2.setText(mWahana.get(position).getTitle());
        Glide.with(mContext).load(temp.getImageId()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mWahana.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView, textView2;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_wahana);
            textView2 = itemView.findViewById(R.id.tv_title_wahana);
            textView = itemView.findViewById(R.id.tv_wahana);
        }
    }
}
