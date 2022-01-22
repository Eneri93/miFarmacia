package com.example.mifarmacia.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.mifarmacia.R;

public class GestionFarmacoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_farmaco);
    }

    public void nuevoFarmaco(View view) {
        Intent intent = new Intent(this,NuevoFarmaco.class);
        startActivity(intent);
    }

    public void actualizar(View view) {
        Intent intent = new Intent(this, ActualizarFarmaco.class);
        startActivity(intent);
    }

    public void mostrarFarmaco(View view) {
        Intent intent = new Intent(this, MostrarFarmaco.class);
        startActivity(intent);
    }
}