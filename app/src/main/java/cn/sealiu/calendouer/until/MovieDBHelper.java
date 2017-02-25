package cn.sealiu.calendouer.until;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static cn.sealiu.calendouer.until.MovieContract.MovieEntry;
import static cn.sealiu.calendouer.until.PersonalContract.PersonalEntry;

/**
 * Created by liuyang
 * on 2017/1/15.
 */

public class MovieDBHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "MOVIE.db";

    private static final String MOVIE_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + MovieEntry.TABLE_NAME + "(" +
                    MovieEntry.COLUMN_NAME_ID + " TEXT PRIMARY KEY, " +
                    MovieEntry.COLUMN_NAME_TITLE + " TEXT, " +
                    MovieEntry.COLUMN_NAME_ORIGINAL_TITLE + " TEXT, " +
                    MovieEntry.COLUMN_NAME_IMAGES + " TEXT, " +
                    MovieEntry.COLUMN_NAME_AVERAGE + " FLOAT, " +
                    MovieEntry.COLUMN_NAME_STARS + " TEXT, " +
                    MovieEntry.COLUMN_NAME_ALT + " TEXT, " +
                    MovieEntry.COLUMN_NAME_YEAR + " TEXT," +
                    MovieEntry.COLUMN_NAME_SUMMARY + " TEXT)";
    private static final String MOVIE_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MovieEntry.TABLE_NAME;

    private static final String PERSONAL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + MovieEntry.TABLE_NAME + "(" +
                    PersonalEntry.COLUMN_NAME_ID + "TEXT PRIMARY KEY, " +
                    PersonalEntry.COLUMN_NAME_KEY + " TEXT, " +
                    PersonalEntry.COLUMN_NAME_VALUE + " TEXT, " +
                    PersonalEntry.COLUMN_NAME_LEVEL + " TEXT, " +
                    PersonalEntry.COLUMN_NAME_DATETIME + " TEXT, " +
                    PersonalEntry.COLUMN_NAME_ALT + " TEXT)";

    private static final String PERSONAL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PersonalEntry.TABLE_NAME;

    public MovieDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MOVIE_CREATE_ENTRIES);
        db.execSQL(PERSONAL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < DB_VERSION) {
            db.execSQL(PERSONAL_CREATE_ENTRIES);
        }
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
