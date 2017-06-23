package app.project.sinsin.project.content;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import app.project.sinsin.project.R;
import app.project.sinsin.project.dao.BaiVietDao;

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
        int maThaiKy = getArguments().getInt("maThaiKy");

        Toast.makeText(getActivity(),maThaiKy+"",Toast.LENGTH_SHORT).show();

        View rootView = inflater.inflate(R.layout.fragment_item_4, container, false);



        BaiVietDao baiVietDao=new BaiVietDao();
        String url=baiVietDao.linkVideo(maThaiKy);


        DisplayMetrics displayMetrics = new DisplayMetrics();

        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//chiều cao
        int height =(int)(displayMetrics.heightPixels/3);
// chiều rộng
        int width = (int)(displayMetrics.widthPixels/1.57);
//        url=url.replace("560",""+width);
//        url=url.replace("315",""+height);


        String html = "<html><body><br>"+url+"</body></html>";

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