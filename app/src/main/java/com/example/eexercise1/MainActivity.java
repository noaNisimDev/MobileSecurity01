package com.example.eexercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button main_BTN_start;
    private int x = 6;
    private TextView main_txt_info;
    private EditText main_LBL_passwordField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_BTN_start = findViewById(R.id.main_BTN_start);
        main_txt_info = findViewById(R.id.main_LBL_info);
        main_LBL_passwordField = findViewById(R.id.main_LBL_passwordField);

        main_BTN_start.setEnabled(false);



        if(isCorrectPass(main_LBL_passwordField.getText().toString())){
            main_BTN_start.setEnabled(true);
        main_BTN_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
                updateUI();
            }

            private void updateUI() {

                main_txt_info.setText("");
            }

            private void start() {
            }
        });
    }
    }
    //TODO
    //continue to write the kinds of if check 1 2 etc
    private boolean isCorrectPass(String password){
        //if(main_LBL_passwordField.getText().toString.equals(check1))
        return true;
    }

    //check1 = %batery
    //check2 = pointing north
}