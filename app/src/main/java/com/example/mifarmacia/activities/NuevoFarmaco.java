package com.example.mifarmacia.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.mifarmacia.R;
import com.example.mifarmacia.clases.Farmacos;
import com.example.mifarmacia.viewModel.FarmacoViewModel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class NuevoFarmaco extends AppCompatActivity {
    private EditText edt_codigo;
    private EditText edt_nombre;
    private EditText edt_marca;
    private EditText edt_principio;
    private EditText edt_precio;
    FarmacoViewModel mFarmacoViewModel;
    String codigo;
    String nombre;
    String marca;
    String principio;
    String precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_farmaco);
        edt_codigo = (EditText) findViewById(R.id.edt_codigo);
        edt_nombre = (EditText) findViewById(R.id.edt_nombre);
        edt_marca = (EditText) findViewById(R.id.edt_marca);
        edt_principio = (EditText) findViewById(R.id.edt_pricipio);
        edt_precio = (EditText) findViewById(R.id.edt_precio);
        mFarmacoViewModel = new ViewModelProvider(this).get(FarmacoViewModel.class);
    }

    public void insertarF(View view) {
        codigo = String.valueOf(edt_codigo.getText());
        nombre = String.valueOf(edt_nombre.getText());
        marca = String.valueOf(edt_marca.getText());
        principio = String.valueOf(edt_principio.getText());
        precio = String.valueOf(edt_precio.getText());
        boolean error = false;
        if(codigo.isEmpty()){
            edt_codigo.setError("escribe el codigo");
            error = true;
        }
        if(nombre.isEmpty()){
            edt_nombre.setError("escribe el nombre");
            error = true;
        }
        if(marca.isEmpty()){
            edt_marca.setError("escribe la marca");
            error = true;
        }
        if(principio.isEmpty()){
            edt_principio.setError("escribe el principio activo");
            error = true;
        }if(precio.isEmpty()){
            edt_precio.setError("escribe el precio");
            error = true;
        }
        if(error)
        {
            return;
        }
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("¿Desea guardar los cambios?");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Farmacos f1= new Farmacos(codigo,nombre,marca,principio,precio);
                boolean insercionOk= mFarmacoViewModel.insertarFarmaco(f1);
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();
    }

    public void mostrarToast(boolean insercionOK)
    {
        if(insercionOK)
        {
            Toast.makeText(this,"se ha guardado correctamente", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"No se ha guardado", Toast.LENGTH_SHORT).show();
        }
    }
}

