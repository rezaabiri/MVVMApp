package com.example.mvvmapp.model.models;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.android.scopes.ActivityScoped;

@ActivityScoped
public class Constructors {
    private final Context context;
    private final Lifecycle lifecycle;
    private final LifecycleOwner lifecycleOwner;
    @Inject
    public Constructors(@ApplicationContext Context context, Lifecycle lifecycle, LifecycleOwner lifecycleOwner) {
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
