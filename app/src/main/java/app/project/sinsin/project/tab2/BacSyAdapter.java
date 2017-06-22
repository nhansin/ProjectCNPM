package app.project.sinsin.project.tab2;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.project.sinsin.project.R;
import app.project.sinsin.project.model.BacSy;

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
        imageViewTen.setImageBitmap(BitmapFactory.decodeByteArray(bacSy.getHinhAnh(), 0, bacSy.getHinhAnh().length));
        tvTenBacSy.setText(bacSy.getTen());


        Button btnGoi = (Button) convertView.findViewById(R.id.btnGoi);
        Button btnEmail = (Button) convertView.findViewById(R.id.btnMail);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                LayoutInflater inflater = getLayoutInflater(savedInstanceState);
                View alertLayout = LayoutInflater.from(context).inflate(R.layout.dialog_bacsy, null);
                ImageView imageBS = (ImageView) alertLayout.findViewById(R.id.imageBS);
                TextView tenBS = (TextView) alertLayout.findViewById(R.id.tvTenBS);
                TextView chuyenMonBS = (TextView) alertLayout.findViewById(R.id.tvChuyenMon);

                BacSy bacSy = listBacSy.get(position);
                imageBS.setImageBitmap(BitmapFactory.decodeByteArray(bacSy.getHinhAnh(), 0, bacSy.getHinhAnh().length));
                tenBS.setText("Bác sỹ " + bacSy.getTen());
                chuyenMonBS.setText("Số điện thoại: "+bacSy.getSoDienThoai()+"\n"
                                    +"Email: "+bacSy.getEmail()+"\n"
                +"Địa chỉ liên hệ: "+bacSy.getDiaChi()+"\n"
                +"Chuyên môn: "+bacSy.getChuyenMon());

                final AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle(bacSy.getTen());
                alert.setView(alertLayout);

                alert.setNegativeButton("Tắt", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = alert.create();
                dialog.show();
                dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.argb(1000,18,165,244));



            }
        });

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


        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String to = listBacSy.get(position).getEmail();
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Thắc mắc gửi đến bác sỹ");
                intent.putExtra(Intent.EXTRA_TEXT, "Xin chào bác sỹ "+listBacSy.get(position).getTen()+"\n");

                intent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(intent,"Send Email");
                context.startActivity(chooser);

            }
        });
        return convertView;
    }
}
