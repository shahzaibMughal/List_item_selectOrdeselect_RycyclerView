package com.example.shahzaib.list_item_selectordeselect_rycyclerview;


import android.graphics.Color;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    List<String> itemTitles;
    SparseBooleanArray sparseBooleanArray; // for identifying: in list which items are selected
    OnRecyclerViewItemClickListener listener;
    int selectedItemCount;


    public RecyclerViewAdapter(List<String> itemTitles, OnRecyclerViewItemClickListener listener)
    {
        this.itemTitles = itemTitles;
        sparseBooleanArray = new SparseBooleanArray();
        this.listener = listener;

        selectedItemCount = 0;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new RecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.itemTextView.setText(itemTitles.get(position));

        if (sparseBooleanArray.get(position))
        {
            holder.itemTextView.setBackgroundColor(Color.GREEN);
        }
        else
        {
            holder.itemTextView.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return itemTitles.size();
    }







    /******** View Holder Class*/
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView itemTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.itemTextView);
            itemTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (!sparseBooleanArray.get(getAdapterPosition()))
            {
                sparseBooleanArray.put(getAdapterPosition(),true);
                selectedItemCount++;
                listener.selectedItemCount(selectedItemCount); // calling the method in main activity Because: in our case mainActivity our created interface for clicklisteners
                notifyItemChanged(getAdapterPosition());
            }
            else // if clicked item is already selected
            {
                sparseBooleanArray.put(getAdapterPosition(),false);
                selectedItemCount--;
                listener.selectedItemCount(selectedItemCount); // calling the method in main activity Because: in our case mainActivity our created interface for clicklisteners
                notifyItemChanged(getAdapterPosition());
            }

        }
    }


    public interface OnRecyclerViewItemClickListener{
        public void selectedItemCount(int count);
    }
}
