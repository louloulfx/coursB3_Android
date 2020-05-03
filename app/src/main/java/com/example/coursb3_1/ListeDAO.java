package com.example.coursb3_1;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public abstract class ListeDAO {
    @Query("SELECT * FROM liste")
    abstract List<ListDTO> getListeListe();

    @Insert
    abstract void insert(ListDTO... liste);

    @Update
    abstract void update(ListDTO... liste);

    @Delete
    abstract void delete(ListDTO... liste);
}
