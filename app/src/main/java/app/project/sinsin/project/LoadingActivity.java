package app.project.sinsin.project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(LoadingActivity.this, MainActivity.class);
//                mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(mainIntent);
                finish();
            }
        }, 1000);

    }
}
