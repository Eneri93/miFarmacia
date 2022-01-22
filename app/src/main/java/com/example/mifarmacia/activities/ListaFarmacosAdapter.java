package com.example.mifarmacia.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mifarmacia.R;
import com.example.mifarmacia.clases.Farmacos;

import java.util.ArrayList;
import java.util.List;

public class ListaFarmacosAdapter extends RecyclerView.Adapter<FarmacosViewHolder>{
    private Context f;
    private List<Farmacos> listaFarmacos;
    private LayoutInflater mInflater;

    public void setF(Context p) {
        this.f = f;
        this.listaFarmacos = new ArrayList<Farmacos>();
    }
    public ListaFarmacosAdapter(Context p, List<Farmacos> listaFarmacos) {
        this.f = f;
        this.listaFarmacos = listaFarmacos;
        mInflater = LayoutInflater.from(p);
    }

    public Context getF() {
        return f;
    }



    public List<Farmacos> getListaFarmacos() {
        return listaFarmacos;
    }

    public void setListaFarmacos(List<Farmacos> listaFarmacos) {
        this.listaFarmacos = listaFarmacos;

        notifyDataSetChanged();
    }

    public ListaFarmacosAdapter(Context f) {
        this.f = f;
        mInflater = LayoutInflater.from(f);
    }

    @NonNull
    @Override
    public FarmacosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_farmaco, parent, false);
        return new FarmacosViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmacosViewHolder holder, int position) {
        if(listaFarmacos!=null) {
            Farmacos farmaco_actual = listaFarmacos.get(position);
            holder.txt_rv_farmaco_precio.setText("Puesto: " + farmaco_actual.getPrecio());
            holder.txt_rv_farmaco_principio.setText("Escudería: " + farmaco_actual.getPrincipio());
            holder.txt_rv_farmaco_marca.setText("Nacionalidad: " + farmaco_actual.getMarca());
        }
    }

    @Override
    public int getItemCount() {
        if (listaFarmacos != null)
            return listaFarmacos.size();
        else return 0;
    }
}

