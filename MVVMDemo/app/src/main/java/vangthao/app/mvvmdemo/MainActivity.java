package vangthao.app.mvvmdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vangthao.app.mvvmdemo.adapter.MovieListAdapter;
import vangthao.app.mvvmdemo.model.MovieModel;
import vangthao.app.mvvmdemo.viewmodel.MovieListViewModel;

public class MainActivity extends AppCompatActivity {

    private List<MovieModel> movieModelList;
    private MovieListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvVideos = findViewById(R.id.rvVideos);
        TextView txtNoResult = findViewById(R.id.txtNoResult);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,1);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVideos.setLayoutManager(layoutManager);
        adapter = new MovieListAdapter(this, movieModelList);
        rvVideos.setAdapter(adapter);

        MovieListViewModel viewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        viewModel.getMoviesListObserver().observe(this, movieModels -> {
            if (movieModels != null) {
                movieModelList = movieModels;
                adapter.setMovieList(movieModels);
                txtNoResult.setVisibility(View.GONE);
            } else {
                txtNoResult.setVisibility(View.VISIBLE);
            }
        });
        viewModel.makeApiCall();
    }
}