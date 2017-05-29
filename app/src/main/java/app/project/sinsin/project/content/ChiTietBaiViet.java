package app.project.sinsin.project.content;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import app.project.sinsin.project.*;

/**
 * Created by SINSIN on 5/10/2017.
 */

public class ChiTietBaiViet extends AppCompatActivity {
    HtmlTextView tv;
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_viet);

        ImageView imageView = (ImageView) findViewById(R.id.imgTest);
        imageView.setImageResource(R.drawable.tuan20);

        tv = (HtmlTextView) findViewById(R.id.content);
        tv.setHtml("<h1 style=\"color: #5e9ca0;\">You can edit <span style=\"color: #f4424e;\">this demo</span> text!</h1>\n" + "<h2 style=\"color: #2e6c80;\">How to use the editor:</h2>\n" + "<p>Paste your documents in the visual editor on the left or your HTML code in the source editor in the right. <br />Edit any of the two areas and see the other changing in real time.&nbsp;</p>\n" + "<p>Click the <span style=\"background-color: #2b2301; color: #fff; display: inline-block; padding: 3px 10px; font-weight: bold; border-radius: 5px;\">Clean</span> button to clean your source code.</p>\n" + "<h2 style=\"color: #2e6c80;\">&nbsp;</h2>", new HtmlHttpImageGetter(tv));


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
