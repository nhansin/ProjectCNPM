package app.project.sinsin.project.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import app.project.sinsin.project.R;
import app.project.sinsin.project.dao.BaiVietDao;
import app.project.sinsin.project.dao.DanhMucChucNangDao;
import app.project.sinsin.project.model.BaiViet;

public class ListBaiViet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bai_viet);

        Intent intent = getIntent();
        int maDanhMuc=intent.getIntExtra("maDanhMuc", 0);
        BaiVietDao baiVietDao=new BaiVietDao();
        DanhMucChucNangDao danhMucChucNangDao=new DanhMucChucNangDao();
        Toast.makeText(this,maDanhMuc+"", Toast.LENGTH_LONG).show();
        final ArrayList<BaiViet> baiViets=baiVietDao.dsDanhMucChucNang(maDanhMuc);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(danhMucChucNangDao.danhMucChucNang(maDanhMuc).getTenDanhMuc());
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ListView listView = (ListView) findViewById(R.id.listBaiViet);
        BaiVietAdapter baiVietAdapter = new BaiVietAdapter(this, R.layout.activity_list_bai_viet, baiViets);
        listView.setAdapter(baiVietAdapter);
        //xlsk nhan vao item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListBaiViet.this, ChiTietBaiViet.class);
                // intent.putExtra("id",id);
                intent.putExtra("maBaiViet",baiViets.get(position).getMaBaiViet());
                startActivity(intent);
            }
        });
    }
}
