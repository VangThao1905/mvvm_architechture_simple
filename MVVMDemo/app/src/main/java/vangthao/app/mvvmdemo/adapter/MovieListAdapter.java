package vangthao.app.mvvmdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vangthao.app.mvvmdemo.R;
import vangthao.app.mvvmdemo.model.MovieModel;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    private final Context context;
    private List<MovieModel> movieList;

    public void setMovieList(List<MovieModel> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    public MovieListAdapter(Context context, List<MovieModel> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtTitle.setText(this.movieList.get(position).getTitle());
        Glide.with(context)
                .load("https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png")
                .into(holder.imgView);
//        Picasso.get().load("ht;tps://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png").into(holder.imgView, new Callback() {
//            @Override
//            public void onSuccess() {
//            }
//
//            @Override
//            public void onError(Exception e) {
//                Log.d("T", e.getMessage());
//            }
//        });

        holder.imgView.setOnClickListener(v -> Toast.makeText(context, "" + movieList.get(position).getTitle(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        if (this.movieList != null) {
            return this.movieList.size();
        }
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtTitle;
        private final ImageView imgView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtTitle = itemView.findViewById(R.id.txtTitle);
            this.imgView = itemView.findViewById(R.id.imgView);
        }
    }
}
