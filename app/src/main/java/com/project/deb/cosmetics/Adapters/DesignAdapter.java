package com.project.deb.cosmetics.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.project.deb.cosmetics.Model.Design;
import com.project.deb.cosmetics.R;
import com.project.deb.cosmetics.Interfaces.OnLoadMoreListener;

import java.util.List;




/**
 * Created by jose on 12/11/17.
 */

public class DesignAdapter extends RecyclerView.Adapter {

    private List<Design> designs;
    private Context context;

    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;

    private int visibleThreshold = 3;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private OnLoadMoreListener onLoadMoreListener;

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

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        }
    }

    public DesignAdapter(List<Design> items, RecyclerView recyclerView, Context context){
        this.designs = items;
        this.context = context;
        if(recyclerView.getLayoutManager() instanceof LinearLayoutManager){
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

                    if(!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)){
                        if(onLoadMoreListener != null){
                            onLoadMoreListener.onLoadMore();
                        }
                    }

                    loading = true;

                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        return designs.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public void setLoaded() {
        loading = false;
    }

    @Override
    public int getItemCount() {
        return designs.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder vh;
        if(viewType == VIEW_ITEM){
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cardview_item,parent, false);

            vh = new MyViewHolder(v);
        }else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.progressbar,parent, false);

            vh = new ProgressViewHolder(v);
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof MyViewHolder){
            ((MyViewHolder)holder).nomTV.setText(designs.get(position).getName());
            //((MyViewHolder)holder).imgIV.setImageResource(designs.get(position).getResourceID());
            Glide.with(this.context).load(designs.get(position).getResourceID()).into(((MyViewHolder)holder).imgIV);

        }else{
            ((ProgressViewHolder)holder).progressBar.setIndeterminate(true);
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
