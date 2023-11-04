package com.example.mvvmapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;

import com.example.mvvmapp.model.models.Constructors;
import com.example.mvvmapp.model.models.shop_items.ShopModel;
import com.example.mvvmapp.model.repositories.ShopRepository;
import com.example.mvvmapp.view.ShopAdapter;
import com.example.mvvmapp.viewmodel.viewmodel_factory.ShopItemDataSourceFactory;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ShopViewModel extends ViewModel {


    private ShopRepository shopRepository;
    private LiveData<PagedList<ShopModel>> shopItems;

    @Inject
    public ShopViewModel(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
        init();
    }

    private void init() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(10)
                .setInitialLoadSizeHint(20)
                .build();

        ShopItemDataSourceFactory factory = new ShopItemDataSourceFactory(shopRepository);

        shopItems = new LivePagedListBuilder<>(factory, config).build();
    }

    public LiveData<PagedList<ShopModel>> getShopItems() {
        return shopItems;
    }

}
