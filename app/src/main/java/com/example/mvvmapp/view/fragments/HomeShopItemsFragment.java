package com.example.mvvmapp.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmapp.R;
import com.example.mvvmapp.databinding.FragmentHomeShopItemsBinding;
import com.example.mvvmapp.view.ShopAdapter;
import com.example.mvvmapp.viewmodel.ShopViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeShopItemsFragment extends Fragment {

    FragmentHomeShopItemsBinding binding;
    private ShopViewModel shopViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_shop_items, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init(){
        shopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        initRecyclerview();
    }

    private void initRecyclerview(){
        binding.setViewModel(shopViewModel);
        binding.setLifecycleOwner(this);
        RecyclerView recyclerView = binding.recyclerShop;
        ShopAdapter adapter = new ShopAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        shopViewModel.getShopItems().observe(getViewLifecycleOwner(), adapter::submitList);
    }
}