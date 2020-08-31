package com.chat.chucknorrisjokes.network;

import com.chat.chucknorrisjokes.model.JokesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("jokes/random/20")
    Call<JokesResponse> getJokesResponse();
}
