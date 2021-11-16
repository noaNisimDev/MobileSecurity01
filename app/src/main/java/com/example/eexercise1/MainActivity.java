package com.example.eexercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button main_BTN_start;
    private TextView main_txt_info;
    private EditText main_LBL_passwordField;
    private int level = 0;
    private int scale = 0;
    private float batteryPct = 0;
    private IntentFilter ifilter;
    private Intent batteryStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_BTN_start = findViewById(R.id.main_BTN_start);
        main_txt_info = findViewById(R.id.main_LBL_info);
        main_LBL_passwordField = findViewById(R.id.main_LBL_passwordField);

        ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        batteryStatus = this.registerReceiver(null, ifilter);
        level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        batteryPct = level * 100 / (float)scale;

        main_LBL_passwordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                main_BTN_start.setEnabled(true);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        main_BTN_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isCorrectPass(Integer.parseInt(main_LBL_passwordField.getText().toString()))){
                    Toast.makeText(getApplicationContext(), "WELL DONE!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "WRONG PASSWORD", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isCorrectPass(int password){
        level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        batteryPct = level * 100 / (float)scale;
        int currentTime = Calendar.getInstance().getTime().getHours();

        if (android.provider.Settings.System.getInt(getContentResolver(),
                Settings.System.ACCELEROMETER_ROTATION, 0) == 1){
            if(password==(batteryPct+currentTime)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}