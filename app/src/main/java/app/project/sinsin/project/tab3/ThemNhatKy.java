package app.project.sinsin.project.tab3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

import app.project.sinsin.project.MainActivity;
import app.project.sinsin.project.R;

/**
 * Created by SINSIN on 5/15/2017.
 */
public class ThemNhatKy extends AppCompatActivity {
    Toolbar toolbar;
    Button btnSave;
    FloatingActionButton fab, fab1, fab2, fab3;
    boolean show;
    File imgFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhat_ky);

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

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThemNhatKy.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });

        fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) System.out.println("Fab");

        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        if (fab1 != null) System.out.println("Fab1");
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        if (fab2 != null) System.out.println("Fab2");

        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        if (fab3 != null) System.out.println("Fab3");
//        fab1.hide();
//        fab2.hide();
//        fab3.hide();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
//                Intent intent = new Intent(getActivity(), ThemNhatKy.class);
//                startActivity(intent);
                if (show == false) {
                    fab1.show();
                    fab2.show();
                    fab3.show();
                    show = true;
                } else {
                    fab1.hide();
                    fab2.hide();
                    fab3.hide();
                    show = false;
                }
            }
        });

        //xu ly su kien cho cac nut con
        //fab1: camera
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                imgFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "filetest.jpg");
                Uri temp = Uri.fromFile(imgFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, temp);
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
                startActivityForResult(intent,0);
            }
        });
        //fab2: gallery
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //fab3: share
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    if (imgFile.exists()) {
                        Toast.makeText(this, "File saved", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case Activity.RESULT_CANCELED:
                    break;
            }
        }
    }
}
