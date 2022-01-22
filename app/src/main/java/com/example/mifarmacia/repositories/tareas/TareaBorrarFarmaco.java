
package com.example.mifarmacia.repositories.tareas;

import com.example.mifarmacia.clases.Farmacos;

import com.example.mifarmacia.repositories.FarmacosRepository;

import java.util.concurrent.Callable;

public class TareaBorrarFarmaco implements Callable<Boolean> {
    private Farmacos f = null;

    public TareaBorrarFarmaco(Farmacos f) {
        this.f = f;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            FarmacosRepository.mfarmacoDao.delete(f);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
