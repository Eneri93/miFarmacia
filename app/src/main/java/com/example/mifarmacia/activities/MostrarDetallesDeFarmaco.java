package com.example.mifarmacia.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.mifarmacia.R;
import com.example.mifarmacia.clases.Farmacos;

import androidx.appcompat.app.AppCompatActivity;

public class MostrarDetallesDeFarmaco extends AppCompatActivity {
    private TextView txt_detalle_codigo;
    private TextView txt_detalle_nombre;
    private TextView txt_detalle_marca;
    private TextView txt_detalle_principio;
    private TextView txt_detalle_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalles_de_farmaco);
        txt_detalle_codigo = (TextView) findViewById(R.id.txt_detalle_codigo);
        txt_detalle_nombre = (TextView) findViewById(R.id.txt_detalle_Nombre);
        txt_detalle_marca = (TextView) findViewById(R.id.txt_detalle_marca);
        txt_detalle_principio = (TextView) findViewById(R.id.txt_detalle_principio);
        txt_detalle_precio = (TextView) findViewById(R.id.txt_detalle_precio);
        Intent intent = getIntent();
        if(intent != null){
            Farmacos f = (Farmacos) intent.getSerializableExtra(FarmacosViewHolder.EXTRA_OBJETO_FARMACO);
            txt_detalle_codigo.setText("codigo: " + f.getCodigo());
            txt_detalle_nombre.setText("Nombre: " + f.getNombre());
            txt_detalle_marca.setText("Marca: " + f.getMarca());
            txt_detalle_principio.setText("Principio: " + f.getPrincipio());
            txt_detalle_precio.setText("precio: " + f.getPrecio());
        }
    }
}