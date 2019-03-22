package com.example.test6_18;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kkang on 2017-03-10.
 */

public class Lab4RecyclerViewAdapter extends RecyclerView.Adapter<ItemHolder> {
    private List<DataVO> list;

    public Lab4RecyclerViewAdapter(List<DataVO> list) {
        this.list = list;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.lab4_sheet_row, parent, false);
        return new ItemHolder(root);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        DataVO vo=list.get(position);
        holder.textView.setText(vo.title);
        holder.imageView.setImageDrawable(vo.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class ItemHolder extends RecyclerView.ViewHolder{

    TextView textView;
    ImageView imageView;

    public ItemHolder(View root) {
        super(root);
        imageView = (ImageView) itemView.findViewById(R.id.lab4_sheet_row_imageView);
        textView = (TextView) itemView.findViewById(R.id.lab4_sheet_row_textView);
    }
}
class DataVO {
    String title;
    Drawable image;
}
