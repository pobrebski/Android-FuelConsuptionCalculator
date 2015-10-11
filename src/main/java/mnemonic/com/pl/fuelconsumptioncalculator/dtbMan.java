package mnemonic.com.pl.fuelconsumptioncalculator;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by mnemonic Dell on 2015-01-26.
 */
public class dtbMan extends SQLiteOpenHelper {

    public dtbMan(Context context){
        super(context, "calcdtb.db", null, 1);
        Log.d("conytext","sql stworzyl baze calcdtb1");}


    public void addEntry(String litre, String kilometers, String consumption, String da){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues entries = new ContentValues();
        Log.d("debuggowanie programu", "zaczynam wrzucac");
        entries.put("refdate", da);
        entries.put("litre", litre);
        entries.put("kilometers", kilometers);
        entries.put("consumption", consumption);
        Log.d("debuggowanie programu", "wrzucilem");
        db.insertOrThrow("refueling", null, entries);
        db.close();

    }
/*
    @Override
    public synchronized void close() {
        SQLiteDatabase db = getReadableDatabase();
        if (db != null)
            db.close();

        super.close();

    }
*/

    public Cursor readDtb(){
        Log.d("chce czytac baze", "mysql");
        String[] coll= {"idrefueling","refdate","litre","kilometers", "consumption"};
        SQLiteDatabase db = getReadableDatabase();
        Log.d("nie dal bazy", "insert");
        Cursor curr = db.query("refueling", coll, null,null,null,null,null);
        Log.d("dal cursor", "insert");
        //db.close(); po dodaniu nie dodaj wpisow
        return curr;

    }

    public void delOne(SQLiteDatabase db, int idrowz){
        int a = idrowz;
       // ++a;
        String [] de = {""+a};
        db.delete("refueling", "idrefueling=?", de);
        Log.d("delOne","sql usunal row");
       // db.close();
    }

    public void delOne(int idrowz){
        int a = idrowz;
        SQLiteDatabase db = getWritableDatabase();

        // ++a;
        /*
        String [] de = {""+a};
        db.delete("refueling", "idrefueling=?", de);
        */
        Log.d("delOne","sql usunal row");
        db.close();
    }

    public void delEntr(SQLiteDatabase db){

                db.execSQL("DROP TABLE refueling;"+
                "drop schema calcdtb1;");

        Log.d("delentr","sql usunal baze");


      /*  db.execSQL(

                "CREATE TABLE refueling (" +
                        "idrefueling integer primary key autoincrement," +
                        "refdate text," +
                        "litre text," +
                        "kilometers text," +
                        "consumption text);" +
                        "");*/


    }


    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(


                "CREATE TABLE refueling (" +
                        "idrefueling integer primary key autoincrement," +
                        "refdate text," +
                        "litre text," +
                        "kilometers text," +
                        "consumption text);" +
                        "");
        Log.d("oncreate","sql stworzyl baze");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){}



}
