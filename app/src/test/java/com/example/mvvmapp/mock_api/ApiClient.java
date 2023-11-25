package com.example.mvvmapp.mock_api;

import com.example.mvvmapp.model.models.shop_items.ShopModel;
import com.example.mvvmapp.model.network.RequestApi;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ApiClient {

    private RequestApi requestApi;

    public ApiClient(RequestApi requestApi) {
        this.requestApi = requestApi;
    }

    public Observable<Response<ArrayList<ShopModel>>> getShopItems(int page) {
        return requestApi.getShopItems(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
