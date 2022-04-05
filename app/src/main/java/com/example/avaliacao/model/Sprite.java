package com.example.avaliacao.model;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Sprite {

    @SerializedName("front_default")
    @Expose
    public String frontDefault;

    public Integer pokemonID;


    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }
}
