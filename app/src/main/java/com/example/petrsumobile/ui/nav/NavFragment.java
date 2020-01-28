package com.example.petrsumobile.ui.nav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.petrsumobile.R;

public class NavFragment extends Fragment {

    private NavViewModel navViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        navViewModel =
                ViewModelProviders.of(this).get(NavViewModel.class);
        View root = inflater.inflate(R.layout.navigation, container, false);
        final TextView textView = root.findViewById(R.id.text_nav);
        navViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}