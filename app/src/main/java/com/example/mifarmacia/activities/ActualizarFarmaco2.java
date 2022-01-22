package com.example.mifarmacia.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.mifarmacia.R;
import com.example.mifarmacia.clases.Farmacos;
import com.example.mifarmacia.viewModel.FarmacoViewModel;

public class ActualizarFarmaco2 extends AppCompatActivity {

    Farmacos fseleccionado;
    private EditText edt_update_codigo;
    private EditText edt_update_nombre;
    private EditText edt_update_marca;
    private EditText edt_update_principio;
    private EditText edt_update_precio;
    FarmacoViewModel mFarmacoViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_farmaco2);
        edt_update_codigo = (EditText) findViewById(R.id.edt_update_codigo);
        edt_update_nombre = (EditText) findViewById(R.id.edt_update_name);
        edt_update_marca = (EditText) findViewById(R.id.edt_update_marca);
        edt_update_principio = (EditText) findViewById(R.id.edt_update_principio);
        edt_update_precio = (EditText) findViewById(R.id.edt_update_precio);
        mFarmacoViewModel = new ViewModelProvider(this).get(FarmacoViewModel.class);
        Intent intent = getIntent();
        if(intent != null)
        {
            fseleccionado = (Farmacos) intent.getSerializableExtra(ActualizarFarmaco.EXTRA_OBJETO_FARMACO);
            if(fseleccionado!=null)
            {
                edt_update_codigo.setText(String.valueOf(fseleccionado.getCodigo()));
                edt_update_codigo.setEnabled(false);
                edt_update_nombre.setText(String.valueOf(fseleccionado.getNombre()));
                edt_update_marca.setText(String.valueOf(fseleccionado.getMarca()));
                edt_update_principio.setText(String.valueOf(fseleccionado.getPrincipio()));
                edt_update_precio.setText(String.valueOf(fseleccionado.getPrecio()));
            }
        }

    }

    public void actualizar(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("¿Desea actualizar?");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String codigo = String.valueOf(edt_update_codigo.getText());
                String nombre = String.valueOf(edt_update_nombre.getText());
                String marca = String.valueOf(edt_update_marca.getText());
                String principio = String.valueOf(edt_update_principio.getText());
                String precio = String.valueOf(edt_update_precio.getText());
                Farmacos f  = new Farmacos (codigo, nombre, marca, principio,precio);
                boolean actualizarOK = mFarmacoViewModel.actualizarFarmaco(f);
                if(actualizarOK)
                {

                    ActualizarFarmaco.adapter.clear();
                    mostrarToast("Actualizado correctamente");
                }
                else{
                    mostrarToast("No se pudo actualizar");
                }
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();
    }
    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
