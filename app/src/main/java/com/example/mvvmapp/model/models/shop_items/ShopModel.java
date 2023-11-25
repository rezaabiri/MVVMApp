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

    public ShopModel(int id, String title, double price, String description, String category, String image, Rating rating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }

    public ShopModel() {
    }

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

