package com.example.mifarmacia.repositories.tareas;

import java.util.concurrent.Callable;
import com.example.mifarmacia.clases.Farmacos;
import com.example.mifarmacia.repositories.FarmacosRepository;

public class TareaInsertarFarmaco implements Callable<Boolean> {
    private Farmacos f = null;

    public TareaInsertarFarmaco(Farmacos f) {
        this.f = f;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            FarmacosRepository.mfarmacoDao.insert(f);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
