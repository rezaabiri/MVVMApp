package com.example.mvvmapp.viewmodel.viewmodel_factory;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.mvvmapp.model.models.Constructors;
import com.example.mvvmapp.model.models.shop_items.ShopModel;
import com.example.mvvmapp.model.repositories.ShopRepository;
import com.example.mvvmapp.model.utils.RepositoryCallback;

import java.util.ArrayList;

public class ShopItemDataSource extends PageKeyedDataSource<Integer, ShopModel> {

    private ShopRepository shopRepository;

    public ShopItemDataSource(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ShopModel> callback) {
        int currentPage = 0;
        int nextPage = currentPage + 1;

        shopRepository.getConfig(currentPage, new RepositoryCallback<ArrayList<ShopModel>>() {
            @Override
            public void onSuccess(ArrayList<ShopModel> data) {
                callback.onResult(data, null, nextPage);
            }

            @Override
            public void onFailure(String errorMessage) {
                // Handle failure
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ShopModel> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ShopModel> callback) {
        int currentPage = params.key;
        int nextPage = currentPage + 1;

        shopRepository.getConfig(currentPage, new RepositoryCallback<ArrayList<ShopModel>>() {
            @Override
            public void onSuccess(ArrayList<ShopModel> data) {
                callback.onResult(data, nextPage);
            }

            @Override
            public void onFailure(String errorMessage) {}
        });
    }
}
