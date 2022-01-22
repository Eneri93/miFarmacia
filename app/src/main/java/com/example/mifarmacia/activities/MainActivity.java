package com.example.mifarmacia.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.mifarmacia.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GestionarF(View view) {
        Intent intent = new Intent(this, GestionFarmacoActivity.class);
        startActivity(intent);
    }
}