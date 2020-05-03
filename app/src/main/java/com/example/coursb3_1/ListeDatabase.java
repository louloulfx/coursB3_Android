package com.example.coursb3_1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ListDTO.class}, version = 1)
public abstract class ListeDatabase extends RoomDatabase {
    public abstract ListeDAO listeDAO();
}
