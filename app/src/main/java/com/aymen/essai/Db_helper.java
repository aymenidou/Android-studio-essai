package com.aymen.essai;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Db_helper extends SQLiteOpenHelper {

    public Db_helper(Context context) {
        super(context, "mydb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists contact (id integer primary key autoincrement,nom text,prenom text,age integer,sexe text,phone integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists contact");
        onCreate(db);
    }

    public boolean insert(Contact c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ligne = new ContentValues();
//        ligne.put("id", c.getId());
        ligne.put("nom", c.getNom());
        ligne.put("prenom", c.getPrenom());
        ligne.put("age", c.getAge());
        ligne.put("sexe", c.getSexe());
        ligne.put("phone", c.getPhone());
        db.insert("contact", null, ligne);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String req = "select * from contact  where id = ?";
        Cursor cur = db.rawQuery(req, new String[]{"id"});
        return cur;
    }

    public boolean updatedata(Contact c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ligne = new ContentValues();
        ligne.put("nom", c.getNom());
        ligne.put("prenom", c.getPrenom());
        ligne.put("age", c.getAge());
        ligne.put("sexe",c.getSexe());
        ligne.put("phone", c.getPhone());
        db.update("contact", ligne, "id = ?", new String[]{"id"});

        return true;
    }

    public Integer deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contact", "id=?", new String[]{"id"});
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("select * from contact", null);
        return cur;
    }

}
