package app.project.sinsin.project.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import app.project.sinsin.project.R;
import app.project.sinsin.project.dao.BaiVietDao;
import app.project.sinsin.project.dao.DanhMucChucNangDao;
import app.project.sinsin.project.model.BaiViet;

public class ListBaiViet extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchView;
    BaiVietAdapter baiVietAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bai_viet);

        Intent intent = getIntent();
        int maDanhMuc = intent.getIntExtra("maDanhMuc", 0);
        BaiVietDao baiVietDao = new BaiVietDao();
        DanhMucChucNangDao danhMucChucNangDao = new DanhMucChucNangDao();
        Toast.makeText(this, maDanhMuc + "", Toast.LENGTH_LONG).show();
        final ArrayList<BaiViet> baiViets = baiVietDao.dsDanhMucChucNang(maDanhMuc);

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

        listView = (ListView) findViewById(R.id.listBaiViet);
        baiVietAdapter = new BaiVietAdapter(this, R.layout.activity_list_bai_viet, baiViets);
        listView.setAdapter(baiVietAdapter);
        //xlsk nhan vao item
        if (maDanhMuc == 1) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ListBaiViet.this, Activity_BaiViet.class);
                    // intent.putExtra("id",id);
                    // intent.putExtra("maBaiViet", baiViets.get(position).getMaBaiViet());
                    startActivity(intent);
                }
            });
        } else {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ListBaiViet.this, ChiTietBaiViet.class);
                    intent.putExtra("id", id);
                    intent.putExtra("maBaiViet", baiViets.get(position).getMaBaiViet());
                    startActivity(intent);
                }
            });
        }
        searchView = (SearchView) findViewById(R.id.search_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // thêm search vào vào action bar
        getMenuInflater().inflate(R.menu.search_view, menu);
        MenuItem itemSearch = menu.findItem(R.id.search_view);
        searchView = (SearchView) itemSearch.getActionView();
        //set OnQueryTextListener cho search view để thực hiện search theo text
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            baiVietAdapter.getFilter().filter("");
            listView.clearTextFilter();
        } else {
            baiVietAdapter.getFilter().filter(newText.toString());
        }
        return true;
    }
}
