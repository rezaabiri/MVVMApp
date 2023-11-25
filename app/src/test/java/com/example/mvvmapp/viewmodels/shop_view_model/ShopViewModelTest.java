package com.example.mvvmapp.viewmodels.shop_view_model;

import androidx.annotation.NonNull;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.example.mvvmapp.model.models.shop_items.Rating;
import com.example.mvvmapp.model.models.shop_items.ShopModel;
import com.example.mvvmapp.model.repositories.ShopRepository;
import com.example.mvvmapp.viewmodel.ShopViewModel;
import com.example.mvvmapp.viewmodel.viewmodel_factory.ShopItemDataSourceFactory;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.example.mvvmapp.*;
import com.example.mvvmapp.viewmodels.factory_mock.ShopItemDataSource;


@RunWith(MockitoJUnitRunner.class)
public class ShopViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private ShopRepository mockShopRepository;

    @InjectMocks
    private ShopViewModel shopViewModel;

    @Mock
    private Observer<PagedList<ShopModel>> mockObserver;

    @Before
    public void setup() {
        ShopItemDataSource mockDataSource = createMockDataSource();

        // ایجاد یک نمونه از ShopItemDataSourceFactory که از موک‌شده ShopRepository استفاده می‌کند
        ShopItemDataSourceFactory mockDataSourceFactory = new ShopItemDataSourceFactory(mockShopRepository);

        // تنظیم کردن ShopItemDataSource موک‌شده به عنوان DataSourceFactory برای ShopItemDataSourceFactory
        when(mockDataSourceFactory.create()).thenReturn(mockDataSource);

        // ایجاد یک نمونه از ShopViewModel با استفاده از ShopItemDataSourceFactory موک‌شده
        shopViewModel = new ShopViewModel(mockShopRepository);

        // افزودن Observer به ShopViewModel
        shopViewModel.getShopItems().observeForever(mockObserver);
    }

    @Test
    public void testGetShopItems() {
        // تست تابع getShopItems
        shopViewModel.getShopItems();

        // تایید صدا زدن متد observeForever بر روی LiveData
        verify(mockObserver).onChanged(any());

        // اطمینان حاصل شود که تابع init به درستی فراخوانی شده است
        assertNotNull(shopViewModel.getShopItems().getValue());
    }

    private ShopItemDataSource createMockDataSource() {
        // ایجاد یک نمونه از ShopItemDataSource با استفاده از داده‌های ثابت
        return new ShopItemDataSource(mockShopRepository) {
            @Override
            public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, ShopModel> callback) {
                super.loadInitial(params, callback);
                List<ShopModel> mockData = new ArrayList<>();
                mockData.add(new ShopModel(1, "title test", 10.0, "desctiption test", "cate", "image", new Rating(1.5f, 2)));
                callback.onResult(mockData, 0, 0);
            }

            @Override
            public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ShopModel> callback) {
                super.loadBefore(params, callback);
            }

            @Override
            public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ShopModel> callback) {
                super.loadAfter(params, callback);
            }
        };
    }
}
