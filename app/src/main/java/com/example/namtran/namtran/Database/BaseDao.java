package com.example.namtran.namtran.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.namtran.namtran.base.DBContext;

/**
 * Created by Nam Tran on 8/17/2015.
 */
public class BaseDao {
    protected DBContext db;
    protected Context context;

    public Cursor loadAll(String table,String[] columns,String orderBy) {
        return db.getReadableDatabase().query(table,columns,null,null,null,null,orderBy);
    }

    public void setContext(Context context) {
        db = new DBContext(context);
        this.context = context;
    }
    public long insert(String table, ContentValues contentValues) {

        return db.getWritableDatabase().insert(table, null, contentValues);
    }
    public long update(String table, ContentValues contentValues,String selection, String[] args) {
        return db.getWritableDatabase().update(table, contentValues, selection, args);
    }
    public long delete(String table, String whereClause, String[] whereArgs)
    {
        return db.getWritableDatabase().delete(table, whereClause, whereArgs);
    }
    private void clearTable(SQLiteDatabase database, String table) {
        // Clear all record
        // Truncate
        database.execSQL("DELETE FROM " + table);
    }
}
