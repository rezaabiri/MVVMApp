package com.example.mvvmapp.model.network;

import com.example.mvvmapp.model.models.shop_items.ShopModel;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestApi {

    @GET("products")
    Observable<Response<ArrayList<ShopModel>>> getShopItems(@Query("page") int page);

}
