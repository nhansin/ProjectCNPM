package app.project.sinsin.project.content;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.project.sinsin.project.*;
import app.project.sinsin.project.model.BaiViet;
import app.project.sinsin.project.tab2.BacSyAdapter;

public class ListBaiViet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bai_viet);

        ArrayList<BaiViet> listBaiViet = new ArrayList<>(); //luc sau lay database bo vao
        listBaiViet.add(new BaiViet(1, "BaiViet1", "Noi dung bai viet 1"));
        listBaiViet.add(new BaiViet(2, "BaiViet2", "Noi dung bai viet 2"));
        listBaiViet.add(new BaiViet(3, "BaiViet3", "Noi dung bai viet 3"));
        listBaiViet.add(new BaiViet(4, "BaiViet4", "Noi dung bai viet 4"));
        listBaiViet.add(new BaiViet(5, "BaiViet5", "Noi dung bai viet 5"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        BaiVietAdapter baiVietAdapter = new BaiVietAdapter(this, R.layout.activity_list_bai_viet, listBaiViet);
        listView.setAdapter(baiVietAdapter);
        //xlsk nhan vao item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListBaiViet.this, ChiTietBaiViet.class);
                startActivity(intent);
            }
        });
    }
}
