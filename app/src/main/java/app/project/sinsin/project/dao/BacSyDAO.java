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
            list.add(new BacSy(cursor.getString(1),cursor.getString(3),cursor.getString(4),cursor.getBlob(5)));
        }
        cursor.close();

        return  list;


    }
}
