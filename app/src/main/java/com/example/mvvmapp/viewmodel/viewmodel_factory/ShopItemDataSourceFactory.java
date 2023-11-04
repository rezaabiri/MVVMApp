package com.example.mvvmapp.viewmodel.viewmodel_factory;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.example.mvvmapp.model.models.Constructors;
import com.example.mvvmapp.model.models.shop_items.ShopModel;
import com.example.mvvmapp.model.repositories.ShopRepository;

public class ShopItemDataSourceFactory extends DataSource.Factory<Integer, ShopModel> {
    private MutableLiveData<ShopItemDataSource> shopItemDataSourceLiveData;
    private ShopRepository shopRepository;

    public ShopItemDataSourceFactory(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
        shopItemDataSourceLiveData = new MutableLiveData<>();
    }

    @Override
    public DataSource<Integer, ShopModel> create() {
        ShopItemDataSource shopItemDataSource = new ShopItemDataSource(shopRepository);
        shopItemDataSourceLiveData.postValue(shopItemDataSource);
        return shopItemDataSource;
    }

    public MutableLiveData<ShopItemDataSource> getShopItemDataSourceLiveData() {
        return shopItemDataSourceLiveData;
    }
}
