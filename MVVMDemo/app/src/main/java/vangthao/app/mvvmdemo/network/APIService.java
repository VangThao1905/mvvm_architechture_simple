package vangthao.app.mvvmdemo.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vangthao.app.mvvmdemo.model.MovieModel;

public interface APIService {
    //volley_array.json
    @GET("volley_array.json")
    Call<List<MovieModel>> getMovieList();
}
