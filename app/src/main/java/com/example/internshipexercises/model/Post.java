package com.example.internshipexercises.model;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;
}
