package app.project.sinsin.project.tab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import app.project.sinsin.project.R;
import app.project.sinsin.project.content.ListBaiViet;
import app.project.sinsin.project.dao.DanhMucChucNangDao;
import app.project.sinsin.project.model.DanhMucChucNang;

/**
 * Created by SINSIN on 5/10/2017.
 */

public class Tab1ChucNang extends Fragment {


    GridView gridView;
    GridViewAdapter adapter;
    // String[] title = {"Demo 1", "Demo 2", "Demo 3", "Demo 4", "Demo 5", "Demo 6", "Demo 7", "Demo 8",};
    DanhMucChucNangDao danhMucChucNang=new DanhMucChucNangDao();
    ArrayList<DanhMucChucNang> danhMucChucNangs=danhMucChucNang.dsDanhMucChucNang();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_tab1, container, false);
        gridView = (GridView) rootView.findViewById(R.id.gridView);
        adapter = new GridViewAdapter(rootView.getContext(),R.layout.gridview_custom,danhMucChucNangs);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), ListBaiViet.class);
                i.putExtra("maDanhMuc",danhMucChucNangs.get(position).getMaDanhMuc());
                startActivity(i);
            }
        });

        return rootView;
    }
}
