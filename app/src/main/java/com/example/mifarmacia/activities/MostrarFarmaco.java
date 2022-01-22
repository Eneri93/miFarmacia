package com.example.mifarmacia.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mifarmacia.R;
import com.example.mifarmacia.clases.Farmacos;
import com.example.mifarmacia.viewModel.FarmacoViewModel;

import java.util.Collections;
import java.util.List;

public class MostrarFarmaco extends AppCompatActivity {
    private RecyclerView rv_farmacos;
    private ListaFarmacosAdapter mAdapter;
    private List<Farmacos> farmacos;
    FarmacoViewModel mFarmacoViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_farmaco);
        rv_farmacos = (RecyclerView) findViewById(R.id.rv_farmacos);
        mFarmacoViewModel = new ViewModelProvider(this).get(FarmacoViewModel.class);

        //-----------------------------------------------------------
        mAdapter = new ListaFarmacosAdapter(this);
        //-----------------------------------------------------------
        mFarmacoViewModel = new ViewModelProvider(this).get(FarmacoViewModel.class);
        LiveData<List<Farmacos>> farmacosLive = mFarmacoViewModel.obtenerfarmacos();
        if(farmacosLive != null) {
            farmacosLive.observe(this, new Observer<List<Farmacos>>() {
                @Override
                public void onChanged(@Nullable final List<Farmacos> losfarmacos) {
                    // Update the cached copy of the words in the adapter.
                    farmacos = losfarmacos;
                    mAdapter.setListaFarmacos(losfarmacos);
                }

            });
        }
        //------------------------------------------------------------
        rv_farmacos.setAdapter(mAdapter);
        rv_farmacos.setLayoutManager(new LinearLayoutManager(this));
        //------------------------------------------------------------

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(farmacos, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction == ItemTouchHelper.LEFT)
                {
                    mostrarToast("ha pulsado izquierda");
                    farmacos.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.RIGHT)
                {
                    mostrarToast("ha pulsado derecha");
                    farmacos.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        helper.attachToRecyclerView(rv_farmacos);
    }

    private void mostrarToast(String texto) {
        Toast.makeText(this,texto, Toast.LENGTH_SHORT).show();
    }

}
