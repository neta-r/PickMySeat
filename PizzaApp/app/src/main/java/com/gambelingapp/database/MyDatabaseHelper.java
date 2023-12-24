package com.gambelingapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.gambelingapp.ReservationObject;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "pizzaStore.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "reservation";
    private static final String COLUMN_ID = "idReservation";
    private static final String COLUMN_DATE = "Date";
    private static final String COLUMN_TIME = "Time";
    private static final String COLUMN_NUM = "NumberOfDiners";
    private static final String COLUMN_NAME = "MainDinerName";
    private static final String COLUMN_TABLE_TAG = "TableTag";

    String DATABASE_PATH;

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        this.DATABASE_PATH = "data/data/" + "com.gambelingapp" + "/databases/";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {;
    }

    public void CheckDB(){
        SQLiteDatabase checkDB = null;
        String filePath = DATABASE_PATH + DATABASE_NAME;
        try{
            checkDB= SQLiteDatabase.openDatabase(filePath, null, 0);
        }
        catch (Exception e){
            CopyDatabase();
        }
    }

    private void CopyDatabase() {
        this.getReadableDatabase();
        try {
            InputStream ios = context.getAssets().open(DATABASE_NAME);
            OutputStream os = new FileOutputStream(DATABASE_PATH+DATABASE_NAME);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = ios.read(buffer))>0){
                os.write(buffer,0,len);
            }

            os.flush();
            ios.close();
            os.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void OpenDatabase(){
        String filepath = DATABASE_PATH+DATABASE_NAME;
        SQLiteDatabase.openDatabase(filepath,null,0);
    }

    public void addReservation(ReservationObject reservationObject){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_DATE, reservationObject.getDate());
        cv.put(COLUMN_TIME, reservationObject.getTime());
        cv.put(COLUMN_NAME, reservationObject.getDinerName());
        cv.put(COLUMN_NUM, reservationObject.getNumOfDiners());
        cv.put(COLUMN_TABLE_TAG, reservationObject.getChosenPlace());
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
