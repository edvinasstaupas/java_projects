package com.lionroar.mokslobaze.ui.egzai;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.lionroar.mokslobaze.MainActivity;
import com.lionroar.mokslobaze.R;
import com.lionroar.mokslobaze.zaidimai.TicTacToe;

public class egzaiFragment extends Fragment {

    private egzaiViewModel egzaiViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        egzaiViewModel =
                ViewModelProviders.of(this).get(egzaiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_egzai, container, false);




        return root;
    }

}