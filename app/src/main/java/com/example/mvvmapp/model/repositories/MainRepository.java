package com.example.mvvmapp.model.repositories;

import com.example.mvvmapp.model.network.RequestApi;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainRepository {
    private final RequestApi requestApi;

    @Inject
    public MainRepository(RequestApi requestApi) {
        this.requestApi = requestApi;
    }

    public RequestApi requestApi() {
        return requestApi;
    }

}
