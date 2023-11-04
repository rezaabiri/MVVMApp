package com.example.mvvmapp.model.network;

import com.example.mvvmapp.model.models.shop_items.ShopModel;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestApi {

    @GET("products")
    Observable<ArrayList<ShopModel>> getShopItems(@Query("page") int page);

}
