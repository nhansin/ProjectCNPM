package app.project.sinsin.project.content;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import app.project.sinsin.project.R;

/**
 * Created by nhan-dev on 6/20/2017.
 */

public class ItemFourFragment extends Fragment {

    String html;
    WebView displayYoutubeVideo;
    Toolbar toolbar;

    public static ItemFourFragment newInstance() {
        ItemFourFragment fragment = new ItemFourFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_4, container, false);


        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = (int) (size.x/2.1);
        int height = (width * 9) / 16;



        String url = "https://www.youtube.com/embed/7KH6L-dDji0";
//        <iframe width="560" height="315" src="" frameborder="0" allowfullscreen></iframe>

        String html = "<html><body><br><iframe width="+width+" height="+height+" src="+url+" frameborder="+0+" allowfullscreen></iframe></body></html>";


        displayYoutubeVideo = (WebView) rootView.findViewById(R.id.webViewVideo);
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        displayYoutubeVideo.loadData(html, "text/html", "utf-8");

        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setTitle("Video");

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