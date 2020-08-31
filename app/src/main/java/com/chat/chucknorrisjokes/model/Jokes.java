package com.chat.chucknorrisjokes.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Jokes {

    private int id;
    private String joke;
    @SerializedName("categories")
    private List<String> categories;

    public Jokes() {
    }

    public Jokes(int id, String joke, List<String> categories) {
        this.id = id;
        this.joke = joke;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}



