package com.example.coursb3_1;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "liste")
public class ListDTO {
    @PrimaryKey(autoGenerate = true)
    public long listeId = 0;
    public String intitule;

    public ListDTO(){}

    @Ignore
    public ListDTO(String intitule) {
        this.intitule = intitule;
    }
}
