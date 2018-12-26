package com.myapp.zarnimyosettwin.dynamicloadrecyclertest.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ZNMSW on 25-Apr-18.
 */
public class RetrofitBuilder {
    public static Api api;
    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public static void buildRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson)) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        api = retrofit.create(Api.class);

        Log.e("Default", Api.BASE_URL);
    }

}