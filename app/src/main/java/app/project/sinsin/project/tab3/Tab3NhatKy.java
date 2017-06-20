package app.project.sinsin.project.tab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import app.project.sinsin.project.R;
import app.project.sinsin.project.dao.NhatKyDao;
import app.project.sinsin.project.model.NhatKy;

/**
 * Created by SINSIN on 5/10/2017.
 */

public class Tab3NhatKy extends Fragment {


    FloatingActionButton fabThemNhatKy, fab1, fab2, fab3;
    boolean show;

    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        NhatKyDao nhatKyDao = new NhatKyDao();
        final ArrayList<NhatKy> listNhatKy = nhatKyDao.danhSachNhatKy();


        View rootView = inflater.inflate(R.layout.activity_tab3, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listViewNhatKy);
        NhatKyAdapter adapter = new NhatKyAdapter(rootView.getContext(), R.layout.listview_nhatky, listNhatKy);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ChiTietNhatKy.class);
                intent.putExtra("maNhatKy", listNhatKy.get(position).getMaNhatKy());
                startActivity(intent);

            }
        });



        fabThemNhatKy = (FloatingActionButton) rootView.findViewById(R.id.fabThemNhatKy);
        if (fabThemNhatKy != null) System.out.println("Fab");



        fabThemNhatKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(getActivity(), ThemNhatKy.class);
                startActivity(intent);

            }
        });


        return rootView;
    }
}