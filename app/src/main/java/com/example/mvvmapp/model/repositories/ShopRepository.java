package com.example.mvvmapp.model.repositories;

import androidx.annotation.NonNull;

import com.example.mvvmapp.model.models.Constructors;
import com.example.mvvmapp.model.models.shop_items.ShopModel;
import com.example.mvvmapp.model.network.RequestApi;
import com.example.mvvmapp.model.utils.RepositoryCallback;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ShopRepository extends BaseRepository {

    private final MainRepository mainRepository;

    @Inject
    public ShopRepository(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public void getConfig(int page, RepositoryCallback<ArrayList<ShopModel>> repositoryCallback) {
        RequestApi shopResponse = mainRepository.requestApi();
        Observable<ArrayList<ShopModel>> initialShopResponse = shopResponse.getShopItems(page);

        initialShopResponse.subscribe(new Observer<ArrayList<ShopModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(ArrayList<ShopModel> shopModels) {
                repositoryCallback.onSuccess(shopModels);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                repositoryCallback.onFailure(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

}
