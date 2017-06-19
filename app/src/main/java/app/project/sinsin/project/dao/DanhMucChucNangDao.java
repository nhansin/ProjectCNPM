package app.project.sinsin.project.dao;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import app.project.sinsin.project.MainActivity;
import app.project.sinsin.project.model.DanhMucChucNang;

/**
 * Created by thuthuy on 6/17/2017.
 */

public class DanhMucChucNangDao {
  public ArrayList<DanhMucChucNang> dsDanhMucChucNang(){
      ArrayList<DanhMucChucNang> list=new ArrayList<>();
      SQLiteDatabase database= MainActivity.database;
      Cursor cursor=database.rawQuery("SELECT * FROM DanhMucChucNang",null);
      for(int i=0;i<cursor.getCount();i++){
          cursor.moveToPosition(i);
          list.add(new DanhMucChucNang(cursor.getInt(0),cursor.getString(1),cursor.getBlob(2)));
      }
      cursor.close();

      return  list;


  }
    public DanhMucChucNang danhMucChucNang(int maDanhMuc){
        DanhMucChucNang dmcn=new DanhMucChucNang();
        SQLiteDatabase database= MainActivity.database;
        Cursor cursor=database.rawQuery("SELECT * FROM DanhMucChucNang where maDanhMuc="+maDanhMuc,null);
         cursor.moveToPosition(0);
        dmcn.setTenDanhMuc(cursor.getString(1));
        cursor.close();

        return  dmcn;


    }

    }

