package com.example.mac.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SettingFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.frame_setting, container);}

    @Override

    public void onActivityCreated ( Bundle savedInstanceState) {

        super .onActivityCreated( savedInstanceState);


    }


}
