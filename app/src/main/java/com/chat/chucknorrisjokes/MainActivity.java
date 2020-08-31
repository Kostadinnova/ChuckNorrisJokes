package com.chat.chucknorrisjokes;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chat.chucknorrisjokes.model.JokesResponse;
import com.chat.chucknorrisjokes.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    JokesAdapter jokesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        jokesAdapter = new JokesAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(jokesAdapter);

        Call<JokesResponse> call = RetrofitClient.getInstance().getExploreService().getJokesResponse();

        call.enqueue(new Callback<JokesResponse>() {
            @Override
            public void onResponse(Call<JokesResponse> call, Response<JokesResponse> response) {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                JokesResponse jokesResponse = response.body();
                jokesAdapter.addJokes(jokesResponse.getJokeList());
            }

            @Override
            public void onFailure(Call<JokesResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });
    }
}
