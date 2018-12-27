package com.brahamaputra.mahindra.brahamaputra.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.brahamaputra.mahindra.brahamaputra.Data.Notification;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "mahindra_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create notes table
        db.execSQL(Notification.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Notification.TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    public long insert(String title, String message, String timestamp) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Notification.COLUMN_TITLE, title);
        values.put(Notification.COLUMN_MESSAGE, message);
        values.put(Notification.COLUMN_TIMESTAMP, timestamp);
        // insert row
        long id = db.insert(Notification.TABLE_NAME, null, values);
        // close db connection
        db.close();
        // return newly inserted row id
        return id;
    }

    public List<Notification> getAllNotification() {
        List<Notification> notes = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Notification.TABLE_NAME + " ORDER BY " + Notification.COLUMN_TIMESTAMP + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Notification note = new Notification();
                note.setId(cursor.getInt(cursor.getColumnIndex(Notification.COLUMN_ID)));
                note.setTitle(cursor.getString(cursor.getColumnIndex(Notification.COLUMN_TITLE)));
                note.setMessage(cursor.getString(cursor.getColumnIndex(Notification.COLUMN_MESSAGE)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(Notification.COLUMN_TIMESTAMP)));
                note.setIsRead(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Notification.COLUMN_ISREAD))));

                notes.add(note);
            } while (cursor.moveToNext());
        }
        // close db connection
        db.close();
        // return notes list
        return notes;
    }

    public int getNotificationCount() {
        String countQuery = "SELECT  * FROM " + Notification.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    public void deleteNotification(Notification note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Notification.TABLE_NAME, Notification.COLUMN_ID + " = ?", new String[]{String.valueOf(note.getId())});
        db.close();
    }

    public void deleteAllNotification() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + Notification.TABLE_NAME);
        db.close();
    }

    public int updateNotification(Notification note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Notification.COLUMN_ISREAD, 1);

        // updating row
        return db.update(Notification.TABLE_NAME, values, Notification.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});

    }

    public boolean updateItem(Notification note) {

        //DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Notification.COLUMN_ID, note.getId());
        values.put(Notification.COLUMN_TITLE, note.getTitle());
        values.put(Notification.COLUMN_MESSAGE, note.getMessage());
        values.put(Notification.COLUMN_ISREAD, 1);

        try {

            String[] args = new String[]{String.valueOf(note.getId())};
            db.update(Notification.TABLE_NAME, values, Notification.COLUMN_ID + "=?", args);
            db.close();
            return true;
        } catch (SQLiteException e) {
            db.close();
            return false;
        }
    }
}
