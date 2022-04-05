package com.example.avaliacao.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Pokemon {
    @SerializedName("abilities")
    @Expose
    public List<Abilities> abilities = null;

    @SerializedName("id")
    @Expose
    @PrimaryKey
    public Integer id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("base_experience")
    @Expose
    @ColumnInfo(name = "first_name")
    public Integer baseExperience;

    @SerializedName("height")
    @Expose
    public Integer height;

    @SerializedName("weight")
    @Expose
    public Integer weight;

    @SerializedName("sprites")
    @Expose
    public Sprite sprites;

    @SerializedName("types")
    @Expose
    public List<Tipies> types = null;

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public List<Tipies> getTypes() {
        return types;
    }

    public void setTypes(List<Tipies> types) {
        this.types = types;
    }
}
