package com.example.kosta.ex40_newwork_project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KOSTA on 2015-07-03.
 */
public class MovieItemAdapter extends BaseAdapter {

    private Context context;
    private List<MovieInfo> movieInfoList;

    public void setMovieInfoList(List<MovieInfo> movieInfoList) {
        this.movieInfoList = movieInfoList;
    }

    public MovieItemAdapter(Context context) {
        this.context = context;
        this.movieInfoList = new ArrayList<MovieInfo>();
    }

    @Override
    public int getCount() {
        return this.movieInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.movieInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MovieInfoHolder holder = null;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.movie_item, parent, false);

            holder = new MovieInfoHolder();
            holder.poster = (ImageView) convertView.findViewById(R.id.poster);
            holder.subject = (TextView) convertView.findViewById(R.id.subject);
            holder.pubDate = (TextView) convertView.findViewById(R.id.pubDate);
            holder.director = (TextView) convertView.findViewById(R.id.director);
            holder.actors = (TextView) convertView.findViewById(R.id.actors);
            holder.userRating = (RatingBar) convertView.findViewById(R.id.userRating);
        }
        else{
            holder = (MovieInfoHolder) convertView.getTag();
        }

        MovieInfo movieInfo = (MovieInfo) getItem(position);
        holder.subject.setText(movieInfo.getSubject());
        holder.pubDate.setText(movieInfo.getPubDate());
        holder.director.setText(movieInfo.getDirector());
        holder.actors.setText(movieInfo.getActors());
        holder.userRating.setRating(movieInfo.getUserRating() / 2.0f);

        getBitmap(movieInfo.getImageUrl(), holder);
        convertView.setTag(holder);

        return convertView;
    }

    private class MovieInfoHolder{

        public ImageView poster;
        public TextView subject;
        public TextView pubDate;
        public TextView director;
        public TextView actors;
        public RatingBar userRating;
    }

    private void getBitmap(final String url, final MovieInfoHolder holder){

        // http 요청하기 위해 thread 필요
        new Thread(){

            @Override
            public void run() {
                if(url.length() > 0){
                    URL imgUrl = null;
                    HttpURLConnection connection = null;

                    try{
                        imgUrl = new URL(url);
                        connection = (HttpURLConnection) imgUrl.openConnection();
                        connection.setDoInput(true);
                        connection.connect();

                        final Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());

                        ((MainActivity)context).getHandler().post(new Runnable() {
                            @Override
                            public void run() {

                                holder.poster.setImageBitmap(bitmap);
                            }
                        });

                    }catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
                        if(connection != null){
                            connection.disconnect();
                        }
                    }
                }
            }
        }.start();
    }
}

