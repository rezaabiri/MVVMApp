package com.example.mvvmapp.view.fragments;

import static com.example.mvvmapp.Utils.goneNav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
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
        goneNav(getActivity());
        buyProduct();
    }

    private void getDataBundle(){
        assert getArguments() != null;
        float rating = getArguments().getFloat("rating");
        String image = getArguments().getString("image");
        String title = getArguments().getString("title");
        String desc = getArguments().getString("desc");
        String price = getArguments().getString("price");

        binding.rating.setRating(rating);
        Glide.with(this).load(image).into(binding.imageview);
        binding.productName.setText(title);
        binding.productDesc.setText(desc);
        binding.productPrice.setText(price+" $ ");
    }

    private void buyProduct(){
        binding.buttonBuy.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_productDetailsFragment_to_profileFragment);

           /* Navigation.findNavController(view).navigate(
                    R.id.action_productDetailsFragment_to_profileFragment,
                    null,
                    new NavOptions.Builder()
                            .setPopUpTo(R.id.profileFragment, true)
                            .build()
            );*/

        });
    }
}