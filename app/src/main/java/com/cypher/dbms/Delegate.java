package com.cypher.dbms;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Delegate_info")
public class Delegate {
    @PrimaryKey @NonNull
    @ColumnInfo(name = "DelegateID")
    public String mDelegate;
    public Delegate(String delegate){this.mDelegate=delegate;}
    public String getmDelegate(){return this.mDelegate;}
}

