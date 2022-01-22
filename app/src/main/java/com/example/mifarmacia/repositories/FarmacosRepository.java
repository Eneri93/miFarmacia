package com.example.mifarmacia.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mifarmacia.clases.Farmacos;
import com.example.mifarmacia.dao.DAOFarmaco;
import com.example.mifarmacia.repositories.tareas.TareaActualizarFarmaco;
import com.example.mifarmacia.repositories.tareas.TareaBorrarFarmaco;
import com.example.mifarmacia.repositories.tareas.TareaInsertarFarmaco;
import com.example.mifarmacia.repositories.tareas.TareaObtenerFarmaco;
import com.example.mifarmacia.roomDataBase.FarmacoRoomDatabase;


import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FarmacosRepository {
    public static DAOFarmaco mfarmacoDao;
    private LiveData<List<Farmacos>> mAllfarmaco;

    public FarmacosRepository(Application application) {
        FarmacoRoomDatabase db = FarmacoRoomDatabase.getDatabase(application);
        mfarmacoDao = db.FarmacoDAO();
        mAllfarmaco= mfarmacoDao.cogerTodosLosFarmacos();
    }

    public LiveData<List<Farmacos>> getmAllfarmaco() {
        return mAllfarmaco;
    }

    public static boolean insertarFarmaco(Farmacos c) {
        FutureTask t = new FutureTask(new TareaInsertarFarmaco(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insercionOK;
        }
    }

    //---------------------------------------------------------------------------

    public static LiveData<List<Farmacos>> obtenerFarmacos()
    {
        LiveData<List<Farmacos>> farmacosDevueltos = null;
        FutureTask t = new FutureTask (new TareaObtenerFarmaco());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            farmacosDevueltos= (LiveData<List<Farmacos>>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return farmacosDevueltos;
    }
    //---------------------------------------------------------------------------
    public static boolean   borrarFarmaco(Farmacos c) {
        FutureTask t = new FutureTask(new TareaBorrarFarmaco(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return borradoOK;
        }
    }
    //---------------------------------------------------------------------------

    public static boolean actualizarFarmaco(Farmacos c) {
        FutureTask t = new FutureTask(new TareaActualizarFarmaco(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean actualizadoOK = false;
        try {
            actualizadoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return actualizadoOK;
        }
    }

}

