package com.example.recyclercard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Example_Adapter extends RecyclerView.Adapter<Example_Adapter.Example_View_Holder> {

    public ArrayList<Ex_item_java> ex_list;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener=listener;
    }
    public static class Example_View_Holder extends RecyclerView.ViewHolder {

        public ImageView iv;
        public TextView tv1;
        public TextView tv2;
        public ImageView del;

        public Example_View_Holder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            del=itemView.findViewById(R.id.del);
            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            listener.onDeleteClick(position);
                        }
                    }

                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }

                }
            });
            iv=itemView.findViewById(R.id.iv);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);

        }
    }

    public Example_Adapter(ArrayList<Ex_item_java> ex_list)
    {
        this.ex_list=ex_list;
    }
    @NonNull
    @Override
    public Example_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.ex_layout,parent,false);
        Example_View_Holder evh=new Example_View_Holder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull Example_View_Holder holder, int position) {
        Ex_item_java currentItem=ex_list.get(position);
        holder.iv.setImageResource(currentItem.getimage());
        holder.tv1.setText(currentItem.getLine1());
        holder.tv2.setText(currentItem.getLine2());

    }

    @Override
    public int getItemCount() {
        return ex_list.size();
    }


}
