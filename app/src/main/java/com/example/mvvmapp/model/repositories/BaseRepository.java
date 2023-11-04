package com.example.mvvmapp.model.repositories;

import androidx.annotation.NonNull;

import com.example.mvvmapp.model.models.Constructors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseRepository {

    public <T> void enqueueWithRetry(Constructors constructors, Call<T> request, Callback<T> callback) {

        request.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if (response.code() == 200){
                    callback.onResponse(call, response);
                }else {
                    callback.onFailure(call, new Throwable());
                }

            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    /*public <T> void refreshTokenAndRetry(Call<T> request, Context context, ViewModelStoreOwner owner, LifecycleOwner lifecycle, Callback<T> callback) {
        try {
            RefreshTokenViewModel viewModel = new ViewModelProvider(owner).get(RefreshTokenViewModel.class);
            CppCodeGenerator cpp = new CppCodeGenerator();
            viewModel.refreshToken(context, sessionManager.getFromSharedPreference(PrefConstants.REFRESH_TOKEN_PREF), cpp.encode(context)).observe(lifecycle, response -> {
                Call<T> refreshedRequest = request.clone();
                refreshedRequest.enqueue(new Callback<T>() {
                    @Override
                    public void onResponse(Call<T> call, Response<T> response) {
                        if (!new ErrorHandler(context).handleError(response, true)) {
                            callback.onResponse(call, response);
                        } else {
                            callback.onFailure(call, new Throwable());
                        }
                    }

                    @Override
                    public void onFailure(Call<T> call, Throwable t) {
                        callback.onFailure(call, t);
                        ErrorHandlerBS errorHandlerBS = new ErrorHandlerBS();
                        errorHandlerBS.showDialog(context, "", "");
                    }
                });
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
}
