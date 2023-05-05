package com.example.dell.togglebutton3;

import android.bluetooth.BluetoothAdapter;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tb;
    CameraManager cm;
    BluetoothAdapter ba;
    WifiManager wm;
    private boolean camera = false;
    private boolean bluetooth = false;
    private boolean wifi = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        cm = (CameraManager) getSystemService(CAMERA_SERVICE);
        ba = BluetoothAdapter.getDefaultAdapter();
        wm = (WifiManager) getSystemService(WIFI_SERVICE);
        tb.setOnCheckedChangeListener((CompoundButton, b) -> {
            if (b) {
                try {
                    String s1 = cm.getCameraIdList()[0];
                    cm.setTorchMode(s1, true);
                    ba.enable();
                    wm.setWifiEnabled(true);
                    wifi = true;
                    camera = true;
                    bluetooth = true;
                } catch (CameraAccessException e) {

                }
            } else {
                try {
                    String s1 = cm.getCameraIdList()[0];
                    cm.setTorchMode(s1, false);
                    ba.disable();
                    wm.setWifiEnabled(false);
                    wifi = false;
                    camera = false;
                    bluetooth = false;
                } catch (CameraAccessException e) {

                }
            }
        }
    }};
}
        }