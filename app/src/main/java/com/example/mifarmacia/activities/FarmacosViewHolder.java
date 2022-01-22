package com.example.mifarmacia.activities;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mifarmacia.R;
import com.example.mifarmacia.clases.Farmacos;

import java.util.List;

public class FarmacosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public static final String EXTRA_OBJETO_FARMACO = "irene.ViewHolder.Unico.farmaco";
    public TextView txt_rv_farmaco_precio;
    public TextView txt_rv_farmaco_marca;
    public TextView txt_rv_farmaco_principio;
    ListaFarmacosAdapter lcAdapter;
    public FarmacosViewHolder(@NonNull View itemView, ListaFarmacosAdapter lcAdapter) {
        super(itemView);
        txt_rv_farmaco_precio = (TextView) itemView.findViewById(R.id.txt_rv_farmaco_precio);
        txt_rv_farmaco_marca = (TextView) itemView.findViewById(R.id.txt_rv_farmaco_marca);
        txt_rv_farmaco_principio = (TextView) itemView.findViewById(R.id.txt_rv_farmaco_principio);
        this.lcAdapter = lcAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int mPosition = getAdapterPosition();
        List<Farmacos> farmacos = this.lcAdapter.getListaFarmacos();
        Farmacos farmaco = farmacos.get(mPosition);
        Intent intent = new Intent(lcAdapter.getF(), MostrarDetallesDeFarmaco.class);
        intent.putExtra(EXTRA_OBJETO_FARMACO, farmaco);
        lcAdapter.getF().startActivity(intent);
    }
}