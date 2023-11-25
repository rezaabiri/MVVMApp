package com.example.mvvmapp.model.repositories;

import android.widget.Toast;

import com.example.mvvmapp.model.models.Constructors;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;
import retrofit2.Response;

public class BaseRepository {

    public <T> Observable<Response<T>> observe(Observable<Response<T>> request) {
        return Observable.create(emitter -> request.subscribe(new Observer<Response<T>>() {
            @Override
            public void onSubscribe(Disposable d) {}

            @Override
            public void onNext(Response<T> t) {
                if (t.isSuccessful()){
                    emitter.onNext(t);
                    //Toast.makeText(constructors.getContext(), "hello", Toast.LENGTH_SHORT).show();
                }else {
                    throw new HttpException(t);
                }
            }

            @Override
            public void onError(Throwable e) {
                emitter.onError(e);
            }

            @Override
            public void onComplete() {
                emitter.onComplete();
            }
        }));
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
