package com.lionroar.mokslobaze.ui.kita;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.lionroar.mokslobaze.R;

public class kitaFragment extends Fragment {

    private kitaViewModel kitaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        kitaViewModel =
                ViewModelProviders.of(this).get(kitaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_kita, container, false);
        return root;


    }

}