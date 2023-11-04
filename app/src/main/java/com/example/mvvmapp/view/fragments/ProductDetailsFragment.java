package com.example.mvvmapp.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmapp.R;
import com.example.mvvmapp.databinding.FragmentProductDetailsBinding;

public class ProductDetailsFragment extends Fragment {
    FragmentProductDetailsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init(){
        getDataBundle();
    }

    private void getDataBundle(){
        assert getArguments() != null;
        int id = getArguments().getInt("id");
       binding.textid.setText(String.valueOf(id));
    }
}