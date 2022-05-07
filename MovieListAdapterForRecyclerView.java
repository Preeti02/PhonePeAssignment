package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
/*
 this class is for implementing recyclerview adapter.
 */
public class MovieListAdapterForRecyclerView extends RecyclerView.Adapter<MovieListAdapterForRecyclerView.ViewHolder>{

      private MovieItemList[] listdata;
      public MovieListAdapterForRecyclerView(MovieItemList[] listdata) {
            this.listdata = listdata;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.movie_list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final MovieItemList myListData = listdata[position];
            holder.movieTitle.setText(listdata[position].getDescription());
            holder.movieSummary.setText(listdata[position].getDescription());
            holder.imageView.setImageResource(listdata[position].getImgId());
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //need to lanch second activity
                }
            });
        }


        @Override
        public int getItemCount() {
            return listdata.length;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView imageView;
            public TextView movieTitle, movieSummary;
            public RelativeLayout relativeLayout;
            public ViewHolder(View itemView) {
                super(itemView);
                this.imageView = (ImageView) itemView.findViewById(R.id.movie_image_id);
                this.movieTitle = (TextView) itemView.findViewById(R.id.movie_title_id);
                this.movieSummary = (TextView) itemView.findViewById(R.id.movie_summary);
                relativeLayout = (RelativeLayout)itemView.findViewById(R.id.movie_relative_layout);
            }
        }
}
