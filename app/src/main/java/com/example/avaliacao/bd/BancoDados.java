package com.example.avaliacao.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import com.example.avaliacao.model.Pokemon;

public class BancoDados extends SQLiteOpenHelper{
    public static final String TABLE_NAME = "pokemon";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_EXP = "base_experience";
    public static final String COLUMN_NAME_HEIGHT = "height";
    public static final String COLUMN_NAME_WEIGHT = "weight";
    public static final String COLUMN_NAME_SPRITE = "sprite";
    public static final String COLUMN_NAME_SKILLS = "skills";
    public static final String COLUMN_NAME_TYPES = "types";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pokemon.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_ID + " INTEGER," +
                    COLUMN_NAME_NAME + " TEXT," +
                    COLUMN_NAME_EXP + " INTEGER," +
                    COLUMN_NAME_HEIGHT + " INTEGER," +
                    COLUMN_NAME_WEIGHT + " INTEGER," +
                    COLUMN_NAME_SPRITE + " TEXT," +
                    COLUMN_NAME_SKILLS + " TEXT," +
                    COLUMN_NAME_TYPES + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


    public BancoDados(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);
    }
}
