package vangthao.app.mvvmdemo.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {
    private static final String BASE_URL = "https://velmm.com/apis/";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitClien() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
