package com.example.avaliacao.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Tipies {
    @SerializedName("slot")
    @Expose
    public Integer slot;

    @SerializedName("type")
    @Expose
    public Type type;

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
