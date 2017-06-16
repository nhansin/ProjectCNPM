package app.project.sinsin.project.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

import app.project.sinsin.project.*;
import app.project.sinsin.project.dao.BaiVietDAO;
import app.project.sinsin.project.model.BaiViet;

/**
 * Created by SINSIN on 5/10/2017.
 */

public class ChiTietBaiViet extends AppCompatActivity {
    WebView noiDung;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_viet);

        noiDung = (WebView) findViewById(R.id.noiDung);
        noiDung.getSettings().setJavaScriptEnabled(true);
        noiDung.getSettings().setDefaultTextEncodingName("utf-8");

        //Tao listBaiViet tu lop DAO

        BaiVietDAO baiVietDAO = new BaiVietDAO();
        ArrayList<BaiViet> listBaiViet = baiVietDAO.listBaiViet;
        Intent i = getIntent();

        int maBaiViet = i.getIntExtra("id", 0);
        System.out.println(maBaiViet);
        String html = listBaiViet.get(maBaiViet).getNoiDung();
        noiDung.loadData(html, "text/html; charset=UTF-8", "utf-8");

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

    }
}
