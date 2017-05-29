package app.project.sinsin.project.tab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import app.project.sinsin.project.R;

/**
 * Created by SINSIN on 4/23/2017.
 */

public class GridViewAdapter extends BaseAdapter {
    Context context;
    String[] txtTitle;
    int[] imgItem;

    public GridViewAdapter(Context context, String[] tenItem, int[] imgItem) {
        this.context = context;
        this.txtTitle = tenItem;
        this.imgItem = imgItem;
    }

    @Override
    public int getCount() {
        return imgItem.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.gridview_custom, null);
        ImageView imgItem = (ImageView) convertView.findViewById(R.id.imgItem);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);

        txtTitle.setText(this.txtTitle[position]);
        imgItem.setImageResource(this.imgItem[position]);
        return convertView;
    }
}
