package com.example.hw2said;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    private TextView tvRes;
    private Button btnMinus,btnPlus,btnNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findId();
        onClick();
    }

    private void findId() {
        tvRes = requireActivity().findViewById(R.id.tv_res);
        btnMinus = requireActivity().findViewById(R.id.tv_res);
        btnPlus = requireActivity().findViewById(R.id.tv_res);
        btnNext = requireActivity().findViewById(R.id.tv_res);

    }

    private void onClick(){
        btnMinus.setOnClickListener(view -> {
            operationMinus();
        });
        btnPlus.setOnClickListener(view -> {
            operationPlus();
        });
        btnNext.setOnClickListener(view -> {
            navigateSec();
        });
    }

    private void operationMinus(){
        int val = Integer.parseInt(tvRes.getText().toString());
        if (val >= 0) {
            val--;
            tvRes.setText(String.valueOf(val));
        }
    }

    private void operationPlus(){
        int val = Integer.parseInt(tvRes.getText().toString());
        if (val < 10){
            val++;
            tvRes.setText(String.valueOf(val));
        } else if (val == 10){
            btnNext.setVisibility(View.VISIBLE);
        }
    }

    private void navigateSec(){
        String value = tvRes.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("num",value);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,secondFragment).commit();

    }

}