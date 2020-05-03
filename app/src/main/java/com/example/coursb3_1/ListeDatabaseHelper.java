package com.example.coursb3_1;

import android.content.Context;

import androidx.room.Room;

public class ListeDatabaseHelper {
    private static ListeDatabaseHelper databaseHelper = null;
    private ListeDatabase database;

    private ListeDatabaseHelper(Context context) {
        database = Room
                .databaseBuilder(context, ListeDatabase.class, "liste.db")
                .allowMainThreadQueries()
                .build();
    }

    static synchronized ListeDatabase getDatabase(Context context) {
        if (databaseHelper == null) {
            databaseHelper = new ListeDatabaseHelper(context.getApplicationContext());
        }
        return databaseHelper.database;
    }
}
