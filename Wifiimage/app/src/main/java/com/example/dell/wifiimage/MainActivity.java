package com.example.dell.wifiimage;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    WifiManager wm;
    private boolean wifi=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib=(ImageButton)findViewById(R.id.imageButton);
        wm=(WifiManager)getSystemService(WIFI_SERVICE);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wifi==false)
                {
                    wm.setWifiEnabled(true);
                    ib.setImageResource(R.drawable.z);
                    wifi=true;
                }
                else
                {
                    wm.setWifiEnabled(false);
                    ib.setImageResource(R.drawable.y);
                    wifi=false;
                }
            }
        });
    }
}
