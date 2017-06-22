package app.project.sinsin.project.tab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import app.project.sinsin.project.R;
import app.project.sinsin.project.dao.NhatKyDao;
import app.project.sinsin.project.model.NhatKy;

/**
 * Created by thuthuy on 6/19/2017.
 */

public class ChiTietNhatKy extends AppCompatActivity {
    Toolbar toolbar;
    Bitmap bitmap;
    FloatingActionButton fabShare;
    ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhatky);
        ImageView imageView = (ImageView) findViewById(R.id.image_nhatky);
        WebView webView = (WebView) findViewById(R.id.view_nhatky);

        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        webView.setLongClickable(false);

        NhatKyDao nhatKyDao = new NhatKyDao();
        Intent intent = getIntent();

        int maNhatKy = intent.getIntExtra("maNhatKy", 0);
        final NhatKy nhatKy = nhatKyDao.nhatKy(maNhatKy);

        imageView.setImageBitmap(BitmapFactory.decodeByteArray(nhatKy.getHinhAnh(), 0, nhatKy.getHinhAnh().length));

        bitmap
                = BitmapFactory.decodeByteArray(nhatKy.getHinhAnh(), 0, nhatKy.getHinhAnh().length);
        TextView textView = (TextView) findViewById(R.id.txtTitleNhatKy);
        textView.setText(nhatKy.getTieuDe());

        StringBuilder html = new StringBuilder();
        html.append("<html>");
        html.append("<head>");
        html.append("<link rel=stylesheet href='css/style.css'>");
        html.append("</head>");
        html.append("<body>");
        //html.append("<h3>"+nhatKy.getTieuDe()+"</h3>");

        html.append("<p style=\"margin-top: 10px;\">" + nhatKy.getNoiDung() + "</p>");

        html.append("</div>");

        html.append("<div><h5>Ngày viết: " + nhatKy.getNgay() + "</h5></div>");


        html.append("</body></html>");

        webView.loadDataWithBaseURL("file:///android_asset/", html.toString(), "text/html", "UTF-8", "");


//        webView.getSettings().setJavaScriptEnabled(true);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Nhật ký");

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fabShare = (FloatingActionButton) findViewById(R.id.fabShare);
        shareDialog = new ShareDialog(ChiTietNhatKy.this);
        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharePhoto photo = new SharePhoto.Builder()
                        .setBitmap(bitmap)
                        .setCaption(nhatKy.getTieuDe() + "\n" + nhatKy.getNoiDung() + "\n" + nhatKy.getNgay())
                        .build();
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();
                shareDialog.show(content);
            }
        });


    }
}
