package app.project.sinsin.project.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import app.project.sinsin.project.MainActivity;
import app.project.sinsin.project.model.DanhMucChucNang;
import app.project.sinsin.project.model.NhatKy;

/**
 * Created by thuthuy on 6/19/2017.
 */

public class NhatKyDao {
    public ArrayList<NhatKy> danhSachNhatKy(){
        ArrayList<NhatKy> listNhatKy=new ArrayList<>();
        SQLiteDatabase database= MainActivity.database;
        Cursor cursor=database.rawQuery("SELECT * FROM NhatKy",null);
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            listNhatKy.add(new NhatKy(cursor.getInt(0),cursor.getString(2),cursor.getString(1),cursor.getString(3),cursor.getBlob(4)));
        }
        cursor.close();
        return  listNhatKy;
    }
    public NhatKy nhatKy(int maNhatKy){
        DanhMucChucNang dmcn=new DanhMucChucNang();
        SQLiteDatabase database= MainActivity.database;
        Cursor cursor=database.rawQuery("SELECT * FROM NhatKy where maNhatKy="+maNhatKy,null);
        cursor.moveToPosition(0);
        NhatKy nhatKy=new NhatKy(cursor.getInt(0),cursor.getString(2),cursor.getString(1),cursor.getString(3),cursor.getBlob(4));
        cursor.close();

        return  nhatKy;


    }
}
