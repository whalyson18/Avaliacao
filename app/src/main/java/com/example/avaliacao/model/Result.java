package com.example.avaliacao.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Result {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("url")
    @Expose
    public String url;
}
