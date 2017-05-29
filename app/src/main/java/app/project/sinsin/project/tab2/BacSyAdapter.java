package app.project.sinsin.project.tab2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.project.sinsin.project.model.BacSy;
import app.project.sinsin.project.R;

/**
 * Created by SINSIN on 4/18/2017.
 */

public class BacSyAdapter extends ArrayAdapter<BacSy> {
    private Context context;
    private int resource;
    ArrayList<BacSy> listBacSy;

    public BacSyAdapter(Context context, int resource, ArrayList<BacSy> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listBacSy = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.listview_bacsy, parent, false);
        ImageView imageViewTen = (ImageView) convertView.findViewById(R.id.imageView);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);

        BacSy bacSy = listBacSy.get(position);
        imageViewTen.setImageResource(R.drawable.logo);
        textView.setText(bacSy.getTen());
        return convertView;
    }
}
