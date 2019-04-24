package com.kermanifar.mohsen.myfirstapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kermanifar.mohsen.myfirstapp.R;
import com.kermanifar.mohsen.myfirstapp.adapter.ClothesAdapter;
import com.kermanifar.mohsen.myfirstapp.datafake.DataFakeGenerator;

public class ClothesFragment extends Fragment {

     View view;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_clothes, container, false);

         recyclerView = view.findViewById(R.id.clothes_recycler);

        ClothesAdapter clothesAdapter = new ClothesAdapter(getActivity(), DataFakeGenerator.getClothes(getActivity()));

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(clothesAdapter);

        return view;
    }

    public static ClothesFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ClothesFragment fragment = new ClothesFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
