package com.example.mvvmapp.mock_api;

import static org.junit.Assert.assertEquals;

import com.example.mvvmapp.model.network.RequestApi;
import com.example.mvvmapp.mock_api.MockApiServer;
import com.example.mvvmapp.model.models.shop_items.ShopModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.TestObserver;
import retrofit2.Response;

public class ApiClientTest {

    private MockApiServer mockApiServer;
    private ApiClient apiClient;

    @Before
    public void setup() throws Exception {
        mockApiServer = new MockApiServer();
        mockApiServer.start();

        // استفاده از مسیر پایه API مصنوعی که از mockApiServer گرفته می‌شود
        String baseUrl = mockApiServer.getBaseUrl();
        RequestApi requestApi = RetrofitClient.createService(RequestApi.class);
        apiClient = new ApiClient(requestApi);
    }

    @After
    public void teardown() throws Exception {
        mockApiServer.stop();
    }

    @Test
    public void testGetShopItems() {
        // آماده‌سازی مثال داده ShopModel برای تست
        ArrayList<ShopModel> fakeShopItems = new ArrayList<>();
        fakeShopItems.add(new ShopModel(/* populate with required fields */));

        String jsonResponse = "{ \"id\": 1, \"title\": \"Sample Product\", \"price\": 29.99, \"description\": \"This is a sample product description.\", \"category\": \"Electronics\", \"image\": \"https://example.com/sample_image.jpg\", \"rating\": { \"ratingValue\": 4.5, \"numReviews\": 100 } }";
        mockApiServer.enqueueResponse(jsonResponse, 200);

        Response<ArrayList<ShopModel>> response = apiClient.getShopItems(1).blockingFirst();

        // بررسی موارد درستی در پاسخ
        assertEquals(200, response.code());
        assertEquals(1, response.body().size());

        ShopModel shopModel = response.body().get(0);
        assertEquals(1, shopModel.getId());
        assertEquals("Sample Product", shopModel.getTitle());
        assertEquals(29.99, shopModel.getPrice(), 0.001); // مقایسه اعشار با مقدار توسط delta
        // بقیه موارد نیز مشابه بالا بررسی می‌شوند
    }
}
