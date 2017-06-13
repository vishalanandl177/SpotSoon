package com.vishalanand.spotsoon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vishal Anand on 13-06-2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
    private List<VideoHolder> videoHolders;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, time, detail;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title_row);
            img = (ImageView) view.findViewById(R.id.img_row);
            time = (TextView) view.findViewById(R.id.time_row);
            detail = (TextView) view.findViewById(R.id.detail_row);
        }
    }


    public VideoAdapter(List<VideoHolder> List) {
        this.videoHolders = List;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        VideoHolder v = videoHolders.get(position);
        holder.title.setText(v.getTitle());
        holder.img.setImageResource(R.drawable.image);
        holder.time.setText(v.getTime());
        holder.detail.setText(v.getDetail());
    }

    @Override
    public int getItemCount() {
        return videoHolders.size();
    }
}
