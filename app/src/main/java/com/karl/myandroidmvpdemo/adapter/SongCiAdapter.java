package com.karl.myandroidmvpdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.karl.myandroidmvpdemo.R;
import com.karl.myandroidmvpdemo.bean.SongCiBean;

import java.util.List;

public class SongCiAdapter extends RecyclerView.Adapter<SongCiAdapter.ViewHolder> {

    List<SongCiBean> datas;

    public SongCiAdapter(List<SongCiBean> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_songci, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SongCiBean d = datas.get(i);
        viewHolder.tvAuthor.setText(d.getAuthors());
        viewHolder.tvTitle.setText(d.getTitle());
        String s = d.getContent().replaceAll("，", "，\n");
        s = s.replaceAll("。", "。\n");
        viewHolder.tvContent.setText( s );
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvAuthor, tvContent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvContent = itemView.findViewById(R.id.tvContent);
        }
    }
}
