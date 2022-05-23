package com.example.data.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Migration_1_2: Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE launchentity (" +
                    "id integer not null, " +
                    "date text not null, " +
                    "PRIMARY KEY(id)" +
                    ")")
    }
}