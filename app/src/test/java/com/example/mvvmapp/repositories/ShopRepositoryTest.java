package com.example.mvvmapp.repositories;

import com.example.mvvmapp.model.models.shop_items.ShopModel;
import com.example.mvvmapp.model.repositories.MainRepository;
import com.example.mvvmapp.model.repositories.ShopRepository;
import com.example.mvvmapp.model.network.RequestApi;
import com.example.mvvmapp.model.utils.RepositoryCallback;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShopRepositoryTest {

    @Mock
    private MainRepository mockMainRepository;

    @Mock
    private RequestApi mockRequestApi;

    private ShopRepository shopRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(mockMainRepository.requestApi()).thenReturn(mockRequestApi);

        // ایجاد شیء ShopRepository با استفاده از موک‌های ما
        shopRepository = new ShopRepository(mockMainRepository);
    }

    @Test
    public void testGetShopItems() {
        // موک کردن خروجی متد getShopItems در شیء mockRequestApi
        when(mockRequestApi.getShopItems(anyInt())).thenReturn(Observable.just(Response.success(new ArrayList<>())));

        // موک کردن یک callback برای متد getShopItems
        RepositoryCallback<ArrayList<ShopModel>> mockCallback = mock(RepositoryCallback.class);

        // اجرای متد مورد نظر
        shopRepository.getShopItems(1, mockCallback);

        // تایید صدا زدن متد onSuccess یکبار و متد onFailure صدا زده نشده است
        verify(mockCallback, times(1)).onSuccess(any());
        verify(mockCallback, never()).onFailure(any());
    }
}
