package vangthao.app.mvvmdemo.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vangthao.app.mvvmdemo.model.MovieModel;
import vangthao.app.mvvmdemo.network.APIService;
import vangthao.app.mvvmdemo.network.RetroInstance;

public class MovieListViewModel extends ViewModel {

    private final MutableLiveData<List<MovieModel>> moviesList;

    public MovieListViewModel() {
        moviesList = new MutableLiveData<>();
    }

    public MutableLiveData<List<MovieModel>> getMoviesListObserver() {
        return moviesList;
    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetrofitClien().create(APIService.class);
        Call<List<MovieModel>> call = apiService.getMovieList();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<MovieModel>> call, @NonNull Response<List<MovieModel>> response) {
                moviesList.postValue(response.body());
                Log.d("TEST", "SUCCESS!");
            }

            @Override
            public void onFailure(@NonNull Call<List<MovieModel>> call, @NonNull Throwable t) {
                moviesList.postValue(null);
                Log.d("TEST", "FAILURE!");
            }
        });
    }
}
