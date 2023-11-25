package com.example.mvvmapp.viewmodels.factory_mock;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.mvvmapp.model.models.shop_items.ShopModel;
import com.example.mvvmapp.model.repositories.ShopRepository;

import java.util.ArrayList;
import java.util.List;

public class ShopItemDataSource extends PageKeyedDataSource<Integer, ShopModel> {

    private final ShopRepository shopRepository;

    public ShopItemDataSource(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ShopModel> callback) {
        // برای مثال، لیست ثابتی از ShopModel ها را به عنوان خروجی بر می‌گردانیم
        List<ShopModel> fixedDataList = createFixedDataList();
        callback.onResult(fixedDataList, null, null);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ShopModel> callback) {
        // اینجا نیازی به پیاده‌سازی نداریم چون داده‌های ما ثابت هستند
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ShopModel> callback) {
        // اینجا نیازی به پیاده‌سازی نداریم چون داده‌های ما ثابت هستند
    }

    private List<ShopModel> createFixedDataList() {
        // ایجاد یک لیست ثابت از ShopModel ها
        List<ShopModel> fixedDataList = new ArrayList<>();
        fixedDataList.add(new ShopModel(/* اطلاعات ShopModel اول */));
        fixedDataList.add(new ShopModel(/* اطلاعات ShopModel دوم */));
        // ...
        return fixedDataList;
    }
}
