package com.example.mvvmapp.model.models;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public class Constructors {
    private final Context context;
    private final Lifecycle lifecycle;
    private final LifecycleOwner lifecycleOwner;
    public Constructors(Context context, Lifecycle lifecycle, LifecycleOwner lifecycleOwner) {
        this.context = context;
        this.lifecycle = lifecycle;
        this.lifecycleOwner = lifecycleOwner;
    }

    public Context getContext() {
        return context;
    }

    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    public LifecycleOwner getLifecycleOwner() {
        return lifecycleOwner;
    }
}
