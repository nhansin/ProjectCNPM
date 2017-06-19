package app.project.sinsin.project.tab1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.project.sinsin.project.R;
import app.project.sinsin.project.model.DanhMucChucNang;

/**
 * Created by SINSIN on 4/23/2017.
 */

public class GridViewAdapter extends ArrayAdapter<DanhMucChucNang> {
    private Context context;
    private int resource;
    ArrayList<DanhMucChucNang> danhMuc;


    public GridViewAdapter(Context context, int resource, ArrayList<DanhMucChucNang> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.danhMuc = objects;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.gridview_custom, parent, false);
        ImageView imageItem = (ImageView) convertView.findViewById(R.id.imgItem);
        TextView textView = (TextView) convertView.findViewById(R.id.txtTitle);

        DanhMucChucNang danhMucChucNang = danhMuc.get(position);
        Bitmap hinhDaiDien= BitmapFactory.decodeByteArray(danhMucChucNang.getHinhAnh(),0,danhMucChucNang.getHinhAnh().length);
        imageItem.setImageBitmap(hinhDaiDien);

        textView.setText(danhMucChucNang.getTenDanhMuc());
        return convertView;
    }
}
