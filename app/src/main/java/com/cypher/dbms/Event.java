package com.cypher.dbms;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="Event")
public class Event{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="EventID")
    public String mEvent;
    public Event(String event){this.mEvent=event;}
    public String getmEvent(){return this.mEvent;}
}
