package com.example.vampire.tinygobang.view.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.vampire.tinygobang.R;
import com.example.vampire.tinygobang.view.aty.GameAty;

/**
 * Created by edgar on 16-5-31.
 */
public class MainFrag extends Fragment implements View.OnClickListener {
    private Button btnHuman,btnHuman_machine,btnWifi_match;
    public static final String FLAG ="flag";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_main,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        btnHuman= (Button) view.findViewById(R.id.human);
        btnHuman_machine= (Button)  view.findViewById(R.id.human_machine);
        btnWifi_match= (Button)  view.findViewById(R.id.wifi_match);
        btnHuman.setOnClickListener(this);
        btnHuman_machine.setOnClickListener(this);
        btnWifi_match.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(),GameAty.class);
        switch (v.getId()){
            case R.id.human:
                intent.putExtra(FLAG,1);
                break;
            case R.id.human_machine:
                intent.putExtra(FLAG,2);
                break;
            case R.id.wifi_match:
                intent.putExtra(FLAG,3);
                break;
        }
        startActivity(intent);
    }
}
