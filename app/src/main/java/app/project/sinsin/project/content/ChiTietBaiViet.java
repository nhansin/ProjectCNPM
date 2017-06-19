package app.project.sinsin.project.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_viet);
        Intent intent =getIntent();
        int id=intent.getIntExtra("id", 0);
        int maBaiViet=intent.getIntExtra("maBaiViet",0);
        Toast.makeText(this,maBaiViet+"",Toast.LENGTH_LONG).show();
        BaiVietDao baiVietDao=new BaiVietDao();

        //  ArrayList<BaiViet> baiViets=baiVietDao.dsDanhMucChucNang(id);
        BaiViet baiViet=baiVietDao.chiTietBaiViet(maBaiViet);
        Toast.makeText(this,maBaiViet+"",Toast.LENGTH_LONG).show();
        String tieuDe=baiViet.getTieuDe();
        String hinhAnh=baiViet.getHinhAnh();
        HashMap<String, String> mapNoiDung=baiViet.getListNoiDung();

        webView = (WebView) findViewById(R.id.webview);

        StringBuilder html=new StringBuilder();
        html.append("<html>");
        html.append("<head>");
        html.append("<link rel=stylesheet href='css/style.css'>");
        html.append("</head>");
        html.append("<body>");

        html.append("<div align=\"center\"><img src="+hinhAnh+"></div>");
        // html.append("<h3>"+tieuDe+"</h3>");

        html.append("<div id=\"content\">");
        for (String key : mapNoiDung.keySet()) {
            html.append("<li>"+key+"</li>");
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

    }
}
