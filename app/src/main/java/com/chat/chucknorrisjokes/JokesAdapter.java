package com.chat.chucknorrisjokes;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.chat.chucknorrisjokes.model.Jokes;

import java.util.ArrayList;
import java.util.List;

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.JokesViewHolder> {

    private List<Jokes> jokes;
    private Context context;

    public JokesAdapter(Context context) {
        this.context = context;
        jokes = new ArrayList<>();
    }

    public void addJokes(List<Jokes> jokeList) {
        if (jokes.size() > 0) {
            jokes.clear();
            jokes.addAll(jokeList);
        } else {
            jokes.addAll(jokeList);
        }
        notifyItemInserted(jokes.size() - 1);
    }

    @NonNull
    @Override
    public JokesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflateView = LayoutInflater.from(parent.getContext()).inflate(R.layout.jokes, parent, false);
        return new JokesViewHolder(inflateView);

    }

    @Override
    public void onBindViewHolder(@NonNull JokesViewHolder holder, int position) {
        int adapterPosition = holder.getAdapterPosition();
        final Jokes currentJoke = jokes.get(adapterPosition);

        holder.tvJokeNumber.setText("#" + adapterPosition);
        holder.tvJokeText.setText(currentJoke.getJoke());
        if (currentJoke.getCategories().size() != 0) {
            holder.tvJokeCategoryName.setText(currentJoke.getCategories().get(0));
        } else {
            holder.tvJokeCategoryName.setText("Category");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "joke");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, currentJoke.getJoke());
                context.startActivity(Intent.createChooser(sharingIntent, context.getResources().getString(R.string.share_using)));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (jokes.size() != 0) {
            return jokes.size();
        } else {
            return 0;
        }
    }

    static class JokesViewHolder extends RecyclerView.ViewHolder {
        TextView tvJokeTitle, tvJokeNumber, tvJokeText, tvJokeCategory, tvJokeCategoryName;

        public JokesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJokeTitle = itemView.findViewById(R.id.jokesTitle);
            tvJokeNumber = itemView.findViewById(R.id.jokeNumber);
            tvJokeText = itemView.findViewById(R.id.jokeText);
            tvJokeCategory = itemView.findViewById(R.id.jokeCategory);
            tvJokeCategoryName = itemView.findViewById(R.id.categoryName);
        }
    }
}







