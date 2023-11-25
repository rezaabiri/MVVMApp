package com.example.mvvmapp.model.models.shop_items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("rate")
    @Expose
    public float rate;
    @SerializedName("count")
    @Expose
    public int count;

    public Rating(float rate, int count) {
        this.rate = rate;
        this.count = count;
    }

    public Rating() {
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
