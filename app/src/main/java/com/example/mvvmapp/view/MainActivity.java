package com.example.mvvmapp.view;

import static com.example.mvvmapp.Utils.visibleNav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.PopupMenu;

import com.example.mvvmapp.R;
import com.example.mvvmapp.databinding.ActivityMainBinding;
import com.example.mvvmapp.model.models.Constructors;
import com.example.mvvmapp.model.models.shop_items.ShopModel;
import com.example.mvvmapp.viewmodel.ShopViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.disposables.Disposable;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        PopupMenu popupMenu = new PopupMenu(this,null);
        popupMenu.inflate(R.menu.menu_nav);
        Menu menu = popupMenu.getMenu();
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        binding.bottomBar.setupWithNavController(menu, navController);


    }
}