package com.example.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "nova.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createUserTable = "CREATE TABLE users(userID INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR(40), password VARCHAR(30))";
        db.execSQL(createUserTable);

        String createCityTable = "CREATE TABLE cities(cityID INTEGER PRIMARY KEY AUTOINCREMENT, city VARCHAR(20) NOT NULL)";
        db.execSQL(createCityTable);

        String createParkingTable = "CREATE TABLE parkingPlaces(parkingID INTEGER PRIMARY KEY AUTOINCREMENT, parking VARCHAR(40), spaces INT NOT NULL," +
                "city VARCHAR(20), FOREIGN KEY(city) REFERENCES cities(city))";
        db.execSQL(createParkingTable);

        String createReservationTable = "CREATE TABLE reservations(resID INTEGER PRIMARY KEY AUTOINCREMENT, user VARCHAR(40) NOT NULL," +
                "city VARCHAR(20) NOT NULL, datum VARCHAR(20) NOT NULL, vreme VARCHAR(20) NOT NULL, parking VARCHAR(40) NOT NULL, " + "FOREIGN KEY(user)" +
                "REFERENCES users(username), FOREIGN KEY(parking) REFERENCES parkingPlaces(parking), FOREIGN KEY(city) REFERENCES cities(city))";
        db.execSQL(createReservationTable);
    }

    public boolean checkLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?", new String[]{username, password});
        if(cursor.getCount() > 0) {
            return true;
        }else{
            return false;
        }
    }

    public boolean registerUser(String username, String password) {
        SQLiteDatabase read = this.getReadableDatabase();
        Cursor cursor = read.rawQuery("SELECT * FROM users WHERE username=?", new String[]{username});
        if(!(cursor.getCount() > 0)) {
            SQLiteDatabase write = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("username", username);
            cv.put("password", password);
            long insert = write.insert("users", null, cv);
            if(insert == -1) {
                return false;
            }
            else {
                return true;
            }
        }
        else
            return false;
    }

    public boolean addRes(String username, String grad, String datum, String vreme, String parking) {
        SQLiteDatabase read = this.getReadableDatabase();
        Cursor c = read.rawQuery("SELECT * FROM reservations WHERE user=?", new String[]{username});
        if((c.getCount() == 0) || (c.getCount() < 3)) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("user", username);
            cv.put("city", grad);
            cv.put("datum", datum);
            cv.put("vreme", vreme);
            cv.put("parking", parking);
            db.insert("reservations", null, cv);
            return true;
        }
        else
            return false;
    }

    public String checkRes(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT city, datum, vreme, parking FROM reservations WHERE user=?", new String[]{username});
        String result = "";
        if(cursor.moveToFirst()) {
            do {
                result = result + "," + cursor.getString(0) + "," + cursor.getString(1)+ "," + cursor.getString(2) +
                        "," + cursor.getString(3);
            }while(cursor.moveToNext());
            return result;
        }
        else return "0";
    }

    /*public void delete(String user, String grad, String datum, String vreme, String lokacija) {
        SQLiteDatabase write = this.getWritableDatabase();
        Cursor cursor = write.rawQuery("DELETE * FROM reservations WHERE user=? AND city=? AND datum=? AND vreme=? AND parking=?",
                new String[]{user, grad, datum, vreme, lokacija});
    }*/

    public void test() {
        SQLiteDatabase read = this.getReadableDatabase();
        String query = "SELECT * FROM cities";
        Cursor c = read.rawQuery(query, null);
        if(!(c.getCount() > 0)) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("city", "Скопје"); db.insert("cities", null, cv);
            cv.put("city", "Куманово"); db.insert("cities", null, cv);
            cv.put("city", "Тетово"); db.insert("cities", null, cv);
            cv.put("city", "Охрид"); db.insert("cities", null, cv);
            cv.put("city", "Битола"); db.insert("cities", null, cv);
        }

        query = "SELECT * FROM parkingPlaces";
        c = read.rawQuery(query, null);
        if(!(c.getCount() > 0)) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("parking", "Александар Палас"); cv.put("spaces", 50); cv.put("city", "Скопје");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "Нова Македонија"); cv.put("spaces", 55); cv.put("city", "Скопје");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "Олимпико"); cv.put("spaces", 45); cv.put("city", "Скопје");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "Хотел Русија"); cv.put("spaces", 30); cv.put("city", "Скопје");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "ШТУЗ"); cv.put("spaces", 50); cv.put("city", "Куманово");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "Кит Го"); cv.put("spaces", 30); cv.put("city", "Куманово");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "Ramstore Mall"); cv.put("spaces", 60); cv.put("city", "Тетово");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "Palma Mall"); cv.put("spaces", 40); cv.put("city", "Тетово");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "Пристаниште"); cv.put("spaces", 20); cv.put("city", "Охрид");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "Чинар"); cv.put("spaces", 25); cv.put("city", "Охрид");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "Билјанини Извори"); cv.put("spaces", 30); cv.put("city", "Охрид");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "Широк Сокак"); cv.put("spaces", 50); cv.put("city", "Битола");
            db.insert("parkingPlaces", null, cv);
            cv.put("parking", "Технички Факултет"); cv.put("spaces", 40); cv.put("city", "Битола");
            db.insert("parkingPlaces", null, cv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
