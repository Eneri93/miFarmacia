package com.example.mifarmacia.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mifarmacia.clases.Farmacos;
import com.example.mifarmacia.repositories.FarmacosRepository;

import java.util.List;

public class FarmacoViewModel extends AndroidViewModel {
    private FarmacosRepository mRepository;
    private LiveData<List<Farmacos>> mAllFarmacos;

    public FarmacoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new FarmacosRepository(application);
        mAllFarmacos = mRepository.getmAllfarmaco();
    }
    public LiveData<List<Farmacos>> obtenerfarmacos()
    {
        LiveData<List<Farmacos>> mAllFarmaco = mRepository.getmAllfarmaco();
        return mAllFarmaco;
    }

    public boolean insertarFarmaco(Farmacos c)
    {
        boolean insercionOK = mRepository.insertarFarmaco(c);
        return insercionOK;
    }

    public boolean borrarFarmaco(Farmacos c)
    {
        boolean borradoOK = mRepository.borrarFarmaco(c);
        return borradoOK;
    }

    public  boolean actualizarFarmaco(Farmacos c)
    {
        boolean actualizacionOK = mRepository.actualizarFarmaco(c);
        return actualizacionOK;
    }
}
