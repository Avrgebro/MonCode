package com.project.deb.cosmetics.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.project.deb.cosmetics.Model.Design;
import com.project.deb.cosmetics.R;

import java.util.List;




/**
 * Created by jose on 12/11/17.
 */

public class DesignAdapter extends RecyclerView.Adapter<DesignAdapter.MyViewHolder> {

    private List<Design> designs;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nomTV;
        private ImageView imgIV;
        private View viewV;
        private CardView cv;

        public MyViewHolder(View view){
            super(view);
            cv = (CardView) view.findViewById(R.id.cardview);
            nomTV = (TextView) view.findViewById(R.id.namecv);
            imgIV = (ImageView) view.findViewById(R.id.imgcv);

        }

    }

    public DesignAdapter(List<Design> items){
        this.designs = items;
    }

    @Override
    public int getItemCount() {
        return designs.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_item,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nomTV.setText(designs.get(position).getName());
        holder.imgIV.setImageResource(designs.get(position).getResourceID());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
