package com.example.mifarmacia.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.mifarmacia.R;
import com.example.mifarmacia.clases.Farmacos;
import com.example.mifarmacia.viewModel.FarmacoViewModel;

import java.util.List;

public class ActualizarFarmaco extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    public static final String EXTRA_OBJETO_FARMACO = "es.irene.actualizarfarmaco1.farmaco";
    private Spinner sp_actualizar = null;
    FarmacoViewModel mFarmacoViewModel = null;
    static Farmacos fseleccionado = null;
    static ArrayAdapter<Farmacos> adapter = null;
    LiveData<List<Farmacos>> farmacosLive= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_farmaco);
        sp_actualizar = (Spinner) findViewById(R.id.sp_actualizar);
        sp_actualizar.setOnItemSelectedListener(this);
        mFarmacoViewModel = new ViewModelProvider(this).get(FarmacoViewModel.class);

        farmacosLive= mFarmacoViewModel.obtenerfarmacos();
        if(farmacosLive != null) {
            farmacosLive.observe(this, new Observer<List<Farmacos>>() {
                @Override
                public void onChanged(@Nullable final List<Farmacos> losfarmacos) {
                    asignarAdaptadorSpinnerPrecio(losfarmacos);
                }
            });
        }
        else {
            Toast.makeText(this, "no se han recuperado los farmacos", Toast.LENGTH_SHORT).show();
        }
    }
    private void asignarAdaptadorSpinnerPrecio(List<Farmacos> losPrecios) {
        adapter = new ArrayAdapter<Farmacos>(this , R.layout.item_farmaco, losPrecios);
        sp_actualizar.setAdapter(adapter);
    }


    public void Actualizar1(View view) {
        if(fseleccionado == null)
        {
            mostrarToast("selecciona un farmaco");
            return;
        }

        Intent intent = new Intent(this, ActualizarFarmaco2.class);
        intent.putExtra(EXTRA_OBJETO_FARMACO, fseleccionado);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Farmacos f = (Farmacos) sp_actualizar.getItemAtPosition(position);
        fseleccionado = f;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void eliminar(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("¿Quiere eliminarlo?");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(fseleccionado == null)
                {
                    mostrarToast("selecciona un farmaco");
                    return;
                }
                boolean borradoOK = mFarmacoViewModel.borrarFarmaco(fseleccionado);
                if(borradoOK)
                {
                    mostrarToast("Se ha borrado correctamente");
                }
                else{
                    mostrarToast("No se pudo borrar");
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

