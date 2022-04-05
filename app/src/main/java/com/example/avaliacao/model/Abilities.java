package com.example.avaliacao.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Abilities {
    @SerializedName("ability")
    @Expose
    public Ability ability;

    @SerializedName("is_hidden")
    @Expose
    public Boolean isHidden;

    @SerializedName("slot")
    @Expose
    public Integer slot;

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}
