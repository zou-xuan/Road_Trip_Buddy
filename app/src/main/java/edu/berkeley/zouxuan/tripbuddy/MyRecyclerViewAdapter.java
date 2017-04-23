package edu.berkeley.zouxuan.tripbuddy;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zouxuan on 4/21/17.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.DataViewHolder> {

    private ArrayList<HistoryData> list;



    public static class DataViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        ImageView imageView;
        TextView textView_title;
        TextView textView_content;

        DataViewHolder(View itemview){
            super(itemview);
            cv=(CardView)itemview.findViewById(R.id.card_view);
            imageView=(ImageView)itemview.findViewById(R.id.card_view_image);
            textView_title=(TextView)itemview.findViewById(R.id.card_view_title);
            textView_content=(TextView)itemView.findViewById(R.id.card_view_content);
        }
    }

    public MyRecyclerViewAdapter(ArrayList<HistoryData> list){
        this.list=list;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        DataViewHolder holder=new DataViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImageId());
        holder.textView_title.setText(list.get(position).getTitle());
        holder.textView_content.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
