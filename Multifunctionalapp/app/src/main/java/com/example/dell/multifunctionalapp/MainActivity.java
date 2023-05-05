package com.example.dell.multifunctionalapp;

import android.bluetooth.BluetoothAdapter;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    WifiManager wm;
    CameraManager cm;
    BluetoothAdapter ba;
    private boolean camera=false;
    private boolean bluetooth=false;
    private boolean wifi=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib=(ImageButton)findViewById(R.id.imageButton);
        wm=(WifiManager)getSystemService(WIFI_SERVICE);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        ba=BluetoothAdapter.getDefaultAdapter();
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((camera=false)||(bluetooth=false)||(wifi=false)) {
                    try {
                        String s1 = cm.getCameraIdList()[0];

                        ba.enable();
                        wm.setWifiEnabled(true);
                        cm.setTorchMode(s1, true);
                        ib.setImageResource(R.drawable.x);
                        wifi = true;
                        camera = true;
                        bluetooth = true;
                    } catch (CameraAccessException e) {

                    }
                }
                else {
                    try {
                        String s1=cm.getCameraIdList()[0];
                        ba.disable();
                        wm.setWifiEnabled(false);
                        cm.setTorchMode(s1, false);
                        ib.setImageResource(R.drawable.y);
                        wifi=false;
                        bluetooth=false;
                        camera=false;
                    }
                    catch (CameraAccessException e)
                    {

                    }
                }

            }
        });
    }
}
