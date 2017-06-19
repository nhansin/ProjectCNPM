package app.project.sinsin.project.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;

import app.project.sinsin.project.MainActivity;

/**
 * Created by thuthuy on 6/17/2017.
 */

public class NoiDungBaiVietDao {
    public HashMap<String, String> noiDungBaiViet(int maBaiViet){
      HashMap<String, String> noiDungBaiViet=new HashMap<>();
        SQLiteDatabase database= MainActivity.database;
        Cursor cursor=database.rawQuery("SELECT * FROM NoiDungBaiViet where maBaiViet="+maBaiViet,null);
        for(int i=0; i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            noiDungBaiViet.put(cursor.getString(1),cursor.getString(2));
        }
        return noiDungBaiViet;
    }
}
