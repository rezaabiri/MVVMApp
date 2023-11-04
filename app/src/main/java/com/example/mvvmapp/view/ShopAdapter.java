package com.example.mvvmapp.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmapp.R;
import com.example.mvvmapp.databinding.ItemShopBinding;
import com.example.mvvmapp.model.models.shop_items.ShopModel;
import com.example.mvvmapp.viewmodel.ShopViewModel;

public class ShopAdapter extends PagedListAdapter<ShopModel, ShopAdapter.ShopViewHolder> {

    FragmentActivity fragmentActivity;
    public ShopAdapter(FragmentActivity fragmentActivity) {
        super(DIFF_CALLBACK);
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        ShopModel shopModel = getItem(position);
        holder.binding.setModel(shopModel);
        holder.itemView.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putInt("id", holder.binding.getModel().id);
            NavHostFragment navHostFragment = (NavHostFragment) fragmentActivity.getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
            NavController navController = navHostFragment.getNavController();
            navController.navigate(R.id.action_homeShopItemsFragment_to_productDetailsFragment, bundle);
        });

    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShopBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_shop, parent, false);
        return new ShopViewHolder(binding);
    }

    static class ShopViewHolder extends RecyclerView.ViewHolder {

        public ItemShopBinding binding;

        ShopViewHolder(ItemShopBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @BindingAdapter("image")
    public static void getImage(ImageView view, String url) {
        Glide.with(view).load(url).into(view);
    }

    private static final DiffUtil.ItemCallback<ShopModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<ShopModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull ShopModel oldItem, @NonNull ShopModel newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ShopModel oldItem, @NonNull ShopModel newItem) {
            return oldItem.getId() == newItem.getId();
        }
    };
}