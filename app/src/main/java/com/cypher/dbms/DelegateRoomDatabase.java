package com.cypher.dbms;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.net.ContentHandler;

@Database(entities = {Delegate.class},version = 1)
public abstract class DelegateRoomDatabase extends RoomDatabase {
    public abstract DelegateDao delegateDao();                              //define dao that works with db

    private static volatile DelegateRoomDatabase INSTANCE;


    static DelegateRoomDatabase getDatabase(final Context context) {        // block prevents multiple instances of db being opened at same time
        if (INSTANCE == null) {
            synchronized (DelegateRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DelegateRoomDatabase.class, "delegate_database").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
}