package com.example.mho.examplekotlin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mauricio Hernández on 09-Nov-17.
 */

public class ListAdapter extends RecyclerView.Adapter <ListAdapter.ViewHolder>{

    private List<BasicPOJO> basicPOJOList;

    public ListAdapter(List<BasicPOJO> basicPOJOList){
        this.basicPOJOList = basicPOJOList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BasicPOJO basicPOJO = basicPOJOList.get(position);
        holder.title.setText(basicPOJO.getTitle());
        holder.desc.setText(basicPOJO.getDesc());
    }

    @Override
    public int getItemCount() {
        return basicPOJOList != null ? basicPOJOList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.item_title);
            desc = itemView.findViewById(R.id.item_desc);
        }
    }
}
