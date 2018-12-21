package com.example.maehendra14.pesonamalangraya.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maehendra14.pesonamalangraya.R;
import com.example.maehendra14.pesonamalangraya.model.Komentar;

import java.util.List;

public class KomentarAdapter extends RecyclerView.Adapter<KomentarAdapter.MyViewHolder>{

    private List<Komentar> mKomentar;
    private Context mContext;

    public KomentarAdapter(List<Komentar> komentarList, Context context) {
        mKomentar = komentarList;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item_komentar,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Komentar temp = mKomentar.get(position);
        holder.textView.setText(mKomentar.get(position).getKomen());
    }

    @Override
    public int getItemCount() {
        return mKomentar.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_id_komentar);
        }
    }
}
