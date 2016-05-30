package com.example.vampire.tinygobang.view.aty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vampire.tinygobang.R;

/**
 * Created by X on 2016/4/14 0014.
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private Button btnHuman,btnHuman_machine,btnWifi_match;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnHuman= (Button) findViewById(R.id.human);
        btnHuman_machine= (Button) findViewById(R.id.human_machine);
        btnWifi_match= (Button) findViewById(R.id.wifi_match);
        btnHuman.setOnClickListener(this);
        btnHuman_machine.setOnClickListener(this);
        btnWifi_match.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,GbPanelAty.class);
        switch (v.getId()){
            case R.id.human:
                intent.putExtra("flag","human");
                startActivity(intent);
                break;
            case R.id.human_machine:
                intent.putExtra("flag","human_machine");
                startActivity(intent);
                break;
            case R.id.wifi_match:
                intent.putExtra("flag","wifi_match");
                startActivity(intent);
                break;
        }
    }
}
