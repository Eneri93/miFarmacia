package com.example.mifarmacia.roomDataBase;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mifarmacia.clases.Farmacos;

import com.example.mifarmacia.dao.DAOFarmaco;




@Database(entities = {Farmacos.class}, version = 1, exportSchema = false)
public  abstract class FarmacoRoomDatabase extends RoomDatabase {
    public abstract DAOFarmaco FarmacoDAO();

    private static FarmacoRoomDatabase INSTANCE;

    public static FarmacoRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FarmacoRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FarmacoRoomDatabase.class, "farmaco_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}