package app.project.sinsin.project.tab3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import app.project.sinsin.project.R;

/**
 * Created by SINSIN on 5/15/2017.
 */
public class ThemNhatKy extends AppCompatActivity {
    Toolbar toolbar;
    Button btnSave;
    FloatingActionButton fab, fabCamera, fabGallery, fabShare;
    boolean show;
    File imgFile;
    ImageView imgNhatKy;
    EditText edtTieuDe, edtNoiDung;
    int REQUEST_CODE_CAMERA = 123;
    int REQUEST_CODE_GALLERY = 456;

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

        //xu ly su kien nhan button Save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThemNhatKy.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });

        edtTieuDe = (EditText) findViewById(R.id.editTextTieuDe);
        edtNoiDung = (EditText) findViewById(R.id.editTextNoiDung);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tieuDe = edtTieuDe.getText().toString();
                String noiDung = edtNoiDung.getText().toString();
            }
        });

        imgNhatKy = (ImageView) findViewById(R.id.imgNhatKy);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fabCamera = (FloatingActionButton) findViewById(R.id.fabCamera);
        fabGallery = (FloatingActionButton) findViewById(R.id.fabGallery);
        fabShare = (FloatingActionButton) findViewById(R.id.fabShare);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (show == false) {
                    showButton();
                    show = true;
                } else {
                    hideButton();
                    show = false;
                }
            }
        });

        //xu ly su kien cho cac nut con
        //fabCamera: camera
        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        });
        //fabGallery: gallery
        fabGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);

            }
        });

        //fabShare: share
        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void hideButton() {
        fabCamera.hide();
        fabGallery.hide();
        fabShare.hide();
    }

    private void showButton() {
        fabCamera.show();
        fabGallery.show();
        fabShare.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 123 && resultCode == RESULT_OK && data != null) {
            Bitmap imgCapture = (Bitmap) data.getExtras().get("data");
            imgNhatKy.setImageBitmap(imgCapture);
        }
        if (requestCode == 456 && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap imgGallery = BitmapFactory.decodeStream(inputStream);
                imgNhatKy.setImageBitmap(imgGallery);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}


