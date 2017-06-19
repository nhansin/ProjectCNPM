package app.project.sinsin.project.tab3;

import android.content.Context;
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
import app.project.sinsin.project.model.NhatKy;

/**
 * Created by SINSIN on 5/15/2017.
 */

public class NhatKyAdapter extends ArrayAdapter<NhatKy>{
    private Context context;
    private int resource;
    ArrayList<NhatKy> listNhatKy;

    public NhatKyAdapter(Context context, int resource, ArrayList<NhatKy> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listNhatKy = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.listview_nhatky, parent, false);
        TextView textViewTieuDe = (TextView) convertView.findViewById(R.id.textViewTieuDe);
        TextView textViewNgay = (TextView) convertView.findViewById(R.id.textViewNgay);
        ImageView imageView= (ImageView) convertView.findViewById(R.id.imageViewNhatKy);


        NhatKy nhatKy = listNhatKy.get(position);
        textViewTieuDe.setText(nhatKy.getTieuDe());
        textViewNgay.setText(nhatKy.getNgay());
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(nhatKy.getHinhAnh(),0,nhatKy.getHinhAnh().length));
        return convertView;
    }
}