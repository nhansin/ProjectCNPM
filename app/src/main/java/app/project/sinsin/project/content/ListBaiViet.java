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
import app.project.sinsin.project.dao.BaiVietDAO;
import app.project.sinsin.project.model.BaiViet;
import app.project.sinsin.project.tab2.BacSyAdapter;

public class ListBaiViet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bai_viet);

        BaiVietDAO baiVietDAO = new BaiVietDAO();
        ArrayList<BaiViet> listBaiViet = baiVietDAO.listBaiViet;

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
                System.out.println("Chuyen man hinh");
                Intent intent = new Intent(ListBaiViet.this, ChiTietBaiViet.class);
                intent.putExtra("id",position);
                System.out.println("Gui id sang ChiTietBaiViet");
                startActivity(intent);

            }
        });
    }
}
