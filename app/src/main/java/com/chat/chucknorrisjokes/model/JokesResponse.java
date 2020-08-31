package com.chat.chucknorrisjokes.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokesResponse {
    private String type;

    @SerializedName("value")
    private List<Jokes> jokesList;


    public JokesResponse() {
    }

    public JokesResponse(String type, List<Jokes> jokesList) {
        this.type = type;
        this.jokesList = jokesList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Jokes> getJokeList() {
        return jokesList;
    }

    public void setJokesList(List<Jokes> jokesList) {
        this.jokesList = jokesList;
    }
}


