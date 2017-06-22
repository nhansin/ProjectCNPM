package app.project.sinsin.project.content;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.project.sinsin.project.R;
import app.project.sinsin.project.model.BaiViet;
import app.project.sinsin.project.model.ImageConverter;

/**
 * Created by SINSIN on 4/18/2017.
 */

public class BaiVietAdapter extends ArrayAdapter<BaiViet> {
    private Context context;
    private int resource;
    ArrayList<BaiViet> listBaiViet;

    public BaiVietAdapter(Context context, int resource, ArrayList<BaiViet> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listBaiViet = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.listview_baiviet, parent, false);
        ImageView imageViewTen = (ImageView) convertView.findViewById(R.id.imageView);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);

        BaiViet baiViet = listBaiViet.get(position);
        Bitmap hinhDaiDien= BitmapFactory.decodeByteArray(baiViet.getAnhDaiDien(),0,baiViet.getAnhDaiDien().length);
        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(hinhDaiDien, 100);
        imageViewTen.setImageBitmap(circularBitmap);
        textView.setText(baiViet.getTieuDe());
        return convertView;
    }
}

