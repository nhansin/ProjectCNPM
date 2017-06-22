package app.project.sinsin.project.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import app.project.sinsin.project.MainActivity;
import app.project.sinsin.project.model.BacSy;

/**
 * Created by nhan-dev on 6/4/2017.
 */

public class BacSyDAO {

    public ArrayList<BacSy> listBacSy;

    public BacSyDAO() {
        listBacSy = new ArrayList<>();
     //   createDatabase();
    }

    public ArrayList<BacSy> dsBacSi(){
        ArrayList<BacSy> list=new ArrayList<>();
        SQLiteDatabase database= MainActivity.database;
        Cursor cursor=database.rawQuery("SELECT * FROM BacSi",null);
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            BacSy bacSy=new BacSy();
            bacSy.setMaBacSy(cursor.getInt(0));
            bacSy.setTen(cursor.getString(1));
//            list.add(new BacSy(cursor.getString(1),cursor.getString(3),cursor.getString(4),cursor.getBlob(5)));
            bacSy.setChuyenMon(cursor.getString(2));
            bacSy.setSoDienThoai(cursor.getString(3));
            bacSy.setEmail(cursor.getString(4));
            bacSy.setHinhAnh(cursor.getBlob(5));
            bacSy.setDiaChi(cursor.getString(6));
            list.add(bacSy);
        }
        cursor.close();

        return  list;


    }
}
