package com.example.mvvmapp.model.utils;

public interface RepositoryCallback<T> {
    void onSuccess(T data);
    void onFailure(String errorMessage);
}
