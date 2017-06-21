package app.project.sinsin.project.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.HashMap;

import app.project.sinsin.project.R;
import app.project.sinsin.project.dao.BaiVietDao;
import app.project.sinsin.project.model.BaiViet;

/**
 * Created by nhan-dev on 6/20/2017.
 */

public class ItemOneFragment extends Fragment {

    WebView webView;
    Toolbar toolbar;

    public static ItemOneFragment newInstance() {
        ItemOneFragment fragment = new ItemOneFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_bai_viet, container, false);

        //my code
//        Intent intent = rootView.getIntent();
//        int id = intent.getIntExtra("id", 0);
//        int maBaiViet = intent.getIntExtra("maBaiViet", 0);
        int maBaiViet = 1;
        Toast.makeText(getActivity(), maBaiViet + "", Toast.LENGTH_LONG).show();
        BaiVietDao baiVietDao = new BaiVietDao();

        //  ArrayList<BaiViet> baiViets=baiVietDao.dsDanhMucChucNang(id);
        BaiViet baiViet = baiVietDao.chiTietBaiViet(maBaiViet);
        Toast.makeText(getActivity(), maBaiViet + "", Toast.LENGTH_LONG).show();
        String tieuDe = baiViet.getTieuDe();
        String hinhAnh = baiViet.getHinhAnh();
        HashMap<String, String> mapNoiDung = baiViet.getListNoiDung();

        webView = (WebView) rootView.findViewById(R.id.webview);

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
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setTitle(tieuDe);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity) getActivity()).onBackPressed();
            }
        });
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);


        return rootView;
    }
}