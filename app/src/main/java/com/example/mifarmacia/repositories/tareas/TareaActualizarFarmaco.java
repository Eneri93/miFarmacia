package com.example.mifarmacia.repositories.tareas;

import com.example.mifarmacia.clases.Farmacos;

import com.example.mifarmacia.repositories.FarmacosRepository;

import java.util.concurrent.Callable;

public class TareaActualizarFarmaco implements Callable<Boolean> {
    private Farmacos f = null;

    public TareaActualizarFarmaco(Farmacos f) {
        this.f = f;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            FarmacosRepository.mfarmacoDao.update(f);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}