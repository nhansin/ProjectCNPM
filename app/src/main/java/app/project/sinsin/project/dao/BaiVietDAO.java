package app.project.sinsin.project.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import app.project.sinsin.project.MainActivity;
import app.project.sinsin.project.model.BaiViet;

/**
 * Created by thuthuy on 6/17/2017.
 */

public class BaiVietDao {
    public ArrayList<BaiViet> dsDanhMucChucNang(int maDanhMuc){
        ArrayList<BaiViet> list=new ArrayList<>();
        SQLiteDatabase database= MainActivity.database;
        Cursor cursor=database.rawQuery("SELECT * FROM BaiViet where maDanhMuc="+maDanhMuc,null);
        for(int i=0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            NoiDungBaiVietDao noiDungBaiVietDao=new NoiDungBaiVietDao();
            int maBaiViet=cursor.getInt(1);
            list.add(new BaiViet(maBaiViet,cursor.getString(2),cursor.getBlob(3),cursor.getString(4),noiDungBaiVietDao.noiDungBaiViet(maBaiViet)));
        }
        cursor.close();


        return  list;


    }
    public BaiViet chiTietBaiViet(int maBaiViet){
        BaiViet baiViet=new BaiViet();
        SQLiteDatabase database= MainActivity.database;
        Cursor cursor=database.rawQuery("SELECT * FROM BaiViet where maBaiViet="+maBaiViet,null);
        cursor.moveToPosition(0);
        baiViet.setTieuDe(cursor.getString(4));
        baiViet.setHinhAnh(cursor.getString(2));
        NoiDungBaiVietDao noiDungBaiVietDao=new NoiDungBaiVietDao();
        baiViet.setListNoiDung(noiDungBaiVietDao.noiDungBaiViet(maBaiViet));
        cursor.close();

        return  baiViet;


    }
    public static void main(String[] args){
        BaiVietDao baiVietDao=new BaiVietDao();
        System.out.println(baiVietDao.chiTietBaiViet(1));

    }
}
