package com.example.mvvmapp.model.models.shop_items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShopModel {
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("price")
    @Expose
    public double price;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("category")
    @Expose
    public String category;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("rating")
    @Expose
    public Rating rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
class Rating{
    @SerializedName("rate")
    @Expose
    public double rate;
    @SerializedName("count")
    @Expose
    public int count;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

