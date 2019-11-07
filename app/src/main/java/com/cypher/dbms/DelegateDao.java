package com.cypher.dbms;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface DelegateDao {
    @Insert
    void insert(Delegate DelegateID);
    @Query("Delete from delegate_info")
    void deleteAll();
    @Delete
    void deleteDelegate(Delegate delegate);
    @Query("SELECT * from delegate_info ORDER BY DelegateID ASC")
    LiveData<List<Delegate>>getAlphabatizedWords();
}
