package com.chat.chucknorrisjokes.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.chat.chucknorrisjokes.Constant.BASE_URL;

public class RetrofitClient {
    private static RetrofitClient INSTANCE = null;
    private Retrofit retrofit;

    private RetrofitService retrofitService;

    public RetrofitClient() {

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitService = retrofit.create(RetrofitService.class);
    }

    public static RetrofitClient getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitClient();
        }

        return INSTANCE;
    }

    public RetrofitService getExploreService() {
        return retrofitService;
    }

}
