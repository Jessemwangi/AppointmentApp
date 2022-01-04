package com.example.appointmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnreg=findViewById(R.id.btnreg);
        Button btnmaindpt=findViewById(R.id.btnmaindpt);

        btnreg.setOnClickListener(v -> {
            Intent intent=new Intent(this,NewCustomerActivity.class);
            startActivity(intent);
        });
        btnmaindpt.setOnClickListener(v -> {
            Intent intent=new Intent(this, NewmaindepartmentActivity.class);
            startActivity(intent);
        });
    }
}