package com.example.mifarmacia.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.farmacos.clases.Farmacos;


import java.util.List;

@Dao
public interface DAOFarmaco {
    @Insert
    void insert(Farmacos farmaco);

    @Delete
    void delete(Farmacos farmaco);

    @Query("DELETE FROM farmacos")
    void deleteAll();

    @Update
    void update(Farmacos farmaco);

    @Query("SELECT * from farmacos ORDER BY codigo ASC")
    LiveData<List<Farmacos>> cogerTodosLosFarmacos();


    @Query("SELECT * FROM farmacos WHERE codigo like :codigoe")
    LiveData<Farmacos> CogerFarmacos(String codigoe);
}
