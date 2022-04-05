package com.example.avaliacao.model;

import java.util.List;

public class PokemonDTO {
    public PokemonDTO() {
    }

    public PokemonDTO(Integer id, String name, Integer height, Integer weight, Integer exp, List<String> skills, List<String> types, String sprite) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.exp = exp;
        this.skills = skills;
        this.types = types;
        this.sprite = sprite;
    }

    private Integer id;
    private String name;
    private Integer height;
    private Integer weight;
    private Integer exp;
    private List<String> skills;
    private List<String> types;
    private String sprite;

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

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "PokemonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", exp=" + exp +
                ", skills=" + skills +
                ", types=" + types +
                ", sprite='" + sprite + '\'' +
                '}';
    }
}
