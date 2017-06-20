package app.project.sinsin.project.content;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import app.project.sinsin.project.R;
import app.project.sinsin.project.dao.BaiVietDao;
import app.project.sinsin.project.model.BaiViet;

/**
 * Created by SINSIN on 5/10/2017.
 */

public class ChiTietBaiViet extends AppCompatActivity {
    WebView webView;
    Toolbar toolbar;
    TextView tvTongQuan, tvThucPham, tvMonAn, tvVideo;
    BottomNavigationView bottomNavigation;
    FragmentManager fragmentManager;
    private Fragment fragment;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thai_ky);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        int maBaiViet = intent.getIntExtra("maBaiViet", 0);
        Toast.makeText(this, maBaiViet + "", Toast.LENGTH_LONG).show();
        BaiVietDao baiVietDao = new BaiVietDao();

        //  ArrayList<BaiViet> baiViets=baiVietDao.dsDanhMucChucNang(id);
        BaiViet baiViet = baiVietDao.chiTietBaiViet(maBaiViet);
        Toast.makeText(this, maBaiViet + "", Toast.LENGTH_LONG).show();
        String tieuDe = baiViet.getTieuDe();
        String hinhAnh = baiViet.getHinhAnh();
        HashMap<String, String> mapNoiDung = baiViet.getListNoiDung();

        webView = (WebView) findViewById(R.id.webview);

        //disable selection text in webview
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        webView.setLongClickable(false);


        StringBuilder html = new StringBuilder();
        html.append("<html>");
        html.append("<head>");
        html.append("<link rel=stylesheet href='css/style.css'>");
        html.append("</head>");
        html.append("<body>");

        html.append("<div align=\"center\"><img src=" + hinhAnh + "></div>");
        // html.append("<h3>"+tieuDe+"</h3>");

        html.append("<div id=\"content\">");
        for (String key : mapNoiDung.keySet()) {
            html.append("<li>" + key + "</li>");
            html.append("<p>" + mapNoiDung.get(key) + "</p>");
        }
        html.append("</div>");

        html.append("</body></html>");

        webView.loadDataWithBaseURL("file:///android_asset/", html.toString(), "text/html", "UTF-8", "");


//        webView.getSettings().setJavaScriptEnabled(true);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(tieuDe);

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        Toast.makeText(this, width + "", Toast.LENGTH_LONG).show();

        tvTongQuan = (TextView) findViewById(R.id.tvTongQuan);
        tvTongQuan.setWidth(width / 4);
        tvTongQuan.setHeight(height/15);
        tvTongQuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMonAn.setTextColor(Color.parseColor("#868686"));
                tvTongQuan.setTextColor(Color.WHITE);
                tvThucPham.setTextColor(Color.parseColor("#868686"));
                tvVideo.setTextColor(Color.parseColor("#868686"));

            }
        });

        tvMonAn = (TextView) findViewById(R.id.tvMonAn);
        tvMonAn.setWidth(width / 4);
        tvMonAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTongQuan.setTextColor(Color.parseColor("#868686"));
                tvMonAn.setTextColor(Color.WHITE);
                tvThucPham.setTextColor(Color.parseColor("#868686"));
                tvVideo.setTextColor(Color.parseColor("#868686"));
                Intent i = new Intent(ChiTietBaiViet.this,FragmentList.class);
                i.putExtra("maBaiViet",-1);
                i.putExtra("maDanhMucBaiViet", -1);
                startActivity(i);

            }
        });

        tvThucPham = (TextView) findViewById(R.id.tvThucPham);
        tvThucPham.setWidth(width / 4);
        tvThucPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvThucPham.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvTongQuan.setTextColor(Color.parseColor("#868686"));
                        tvMonAn.setTextColor(Color.parseColor("#868686"));
                        tvThucPham.setTextColor(Color.WHITE);
                        tvVideo.setTextColor(Color.parseColor("#868686"));
                    }
                });
            }
        });

        tvVideo = (TextView) findViewById(R.id.tvVideo);
        tvVideo.setWidth(width / 4);
        tvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvVideo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvTongQuan.setTextColor(Color.parseColor("#868686"));
                        tvMonAn.setTextColor(Color.parseColor("#868686"));
                        tvVideo.setTextColor(Color.WHITE);
                        tvThucPham.setTextColor(Color.parseColor("#868686"));
                    }
                });
            }
        });

        bottomNavigation = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigation.inflateMenu(R.menu.bottom_navigation_main);
        fragmentManager = getSupportFragmentManager();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.action_search:
                        fragment = new SearchFragment();
                        break;
                    case R.id.action_cart:
                        fragment = new CartFragment();
                        break;
                    case R.id.action_hot_deals:
                        fragment = new DealsFragment();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });

    }
}
