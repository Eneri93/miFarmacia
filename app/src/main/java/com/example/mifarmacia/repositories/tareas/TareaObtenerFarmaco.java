package com.example.mifarmacia.repositories.tareas;

import androidx.lifecycle.LiveData;

import com.example.mifarmacia.clases.Farmacos;

import com.example.mifarmacia.repositories.FarmacosRepository;

import java.util.List;
import java.util.concurrent.Callable;

public class TareaObtenerFarmaco implements Callable<LiveData<List<Farmacos>>> {

    @Override
    public LiveData<List<Farmacos>> call() throws Exception {
        try{
            LiveData<List<Farmacos>> farmacos = FarmacosRepository.mfarmacoDao.cogerTodosLosFarmacos();
            return farmacos;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
