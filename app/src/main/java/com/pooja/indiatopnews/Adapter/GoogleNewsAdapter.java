package com.pooja.indiatopnews.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pooja.indiatopnews.R;
import com.pooja.indiatopnews.eventListener.DateTimeConversion;
import com.pooja.indiatopnews.pojo.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GoogleNewsAdapter extends RecyclerView.Adapter<GoogleNewsAdapter.MyViewHolder> {

    Context context;
    ArrayList<Article> articles;
    LayoutInflater inflater;

    public GoogleNewsAdapter(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.articles = articles;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        try {
            View v = inflater.inflate(R.layout.google_news_adapter, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(v);
            return viewHolder;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        String urlImage  = articles.get(position).getUrlToImage();
        Picasso.with(context)
                .load(urlImage)
                .into(holder.imageView);
        holder.title.setText(articles.get(position).getTitle());
        DateTimeConversion dateTimeConversion = new DateTimeConversion();
        holder.mDate.setText( dateTimeConversion.DateFormat_ddMMyyyy(articles.get(position).getPublishedAt()) +" | " +dateTimeConversion.DateFormat_HHmm(articles.get(position).getPublishedAt()));
        Log.e("tag_d",dateTimeConversion.DateFormat_ddMMyyyy(articles.get(position).getPublishedAt()));
        Log.e("tag_date", articles.get(position).getPublishedAt());


    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, mDate;
        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.urlimage);
            title = (TextView) itemView.findViewById(R.id.title);
            mDate = (TextView) itemView.findViewById(R.id.datetime);
        }
    }
}
