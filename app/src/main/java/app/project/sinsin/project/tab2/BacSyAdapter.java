package app.project.sinsin.project.tab2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.listview_bacsy, parent, false);
        ImageView imageViewTen = (ImageView) convertView.findViewById(R.id.imageView);
        final TextView tvTenBacSy = (TextView) convertView.findViewById(R.id.tvTenBacSy);

        BacSy bacSy = listBacSy.get(position);
        imageViewTen.setImageResource(R.drawable.logo);
        tvTenBacSy.setText(bacSy.getTen());


        Button btnGoi = (Button) convertView.findViewById(R.id.btnGoi);
        Button btnEmail = (Button) convertView.findViewById(R.id.btnMail);

        btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + listBacSy.get(position).getSoDienThoai().toString());
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(uri);
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                context.startActivity(intent);

            }
        });
        return convertView;
    }
}
