package com.example.mvvmapp.model.repositories;

import com.example.mvvmapp.model.models.shop_items.ShopModel;
import com.example.mvvmapp.model.network.RequestApi;
import com.example.mvvmapp.model.utils.RepositoryCallback;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;

public class ShopRepository extends BaseRepository {

    private final MainRepository mainRepository;
    @Inject
    public ShopRepository(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public void getShopItems(int page, RepositoryCallback<ArrayList<ShopModel>> repositoryCallback) {
        RequestApi shopResponse = mainRepository.requestApi();
        Observable<Response<ArrayList<ShopModel>>> initialShopResponse = shopResponse.getShopItems(page);

        observe(initialShopResponse).subscribe(
                response -> repositoryCallback.onSuccess(response.body()),
                throwable -> repositoryCallback.onFailure(throwable.getMessage())
        ).dispose();
    }

}
