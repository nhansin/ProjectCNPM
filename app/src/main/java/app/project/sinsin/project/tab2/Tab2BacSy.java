package app.project.sinsin.project.tab2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import app.project.sinsin.project.R;
import app.project.sinsin.project.dao.BacSyDAO;
import app.project.sinsin.project.model.BacSy;

/**
 * Created by SINSIN on 5/10/2017.
 */


public class Tab2BacSy extends Fragment {

    ArrayList<BacSy> listBacSy;

    BacSyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        BacSyDAO bacSyDAO = new BacSyDAO();
        listBacSy = bacSyDAO.dsBacSi();


        View rootView = inflater.inflate(R.layout.activity_tab2, container, false);
        ListView listViewBacSy = (ListView) rootView.findViewById(R.id.listViewBacSy);
        adapter = new BacSyAdapter(rootView.getContext(), R.layout.listview_bacsy, listBacSy);
        listViewBacSy.setAdapter(adapter);

      listViewBacSy.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
          @Override
          public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
              Toast.makeText(getActivity(),position+"",Toast.LENGTH_LONG).show();
              return false;
          }
      });
        return rootView;
    }


//    @Override
//    public void onCreate(@Nullable final Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        listViewBacSy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                LayoutInflater inflater = getLayoutInflater(savedInstanceState);
//                View alertLayout = inflater.inflate(R.layout.dialog_bacsy, null);
//                ImageView imageBS = (ImageView) alertLayout.findViewById(R.id.imageBS);
//                TextView tenBS = (TextView) alertLayout.findViewById(R.id.tvTenBS);
//                TextView chuyenMonBS = (TextView) alertLayout.findViewById(R.id.tvChuyenMon);
//
//                BacSy bacSy = listBacSy.get(position);
//                imageBS.setImageBitmap(BitmapFactory.decodeByteArray(bacSy.getHinhAnh(), 0, bacSy.getHinhAnh().length));
//                tenBS.setText("Bác sỹ " + bacSy.getTen());
//                chuyenMonBS.setText("Số điện thoại: "+bacSy.getSoDienThoai()+"\n"
//                                    +"Email: "+bacSy.getEmail()+"\n"
//                +"Địa chỉ liên hệ: "+bacSy.getDiaChi()+"\n"
//                +"Chuyên môn:"+bacSy.getChuyenMon());
//
//                final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
//                alert.setTitle(bacSy.getTen());
//                alert.setView(alertLayout);
//
//                alert.setNegativeButton("Tắt", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//                AlertDialog dialog = alert.create();
//                dialog.show();
//
//            }
//        });
//
//    }
}
