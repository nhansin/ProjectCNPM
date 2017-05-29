package app.project.sinsin.project.tab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import app.project.sinsin.project.R;
import app.project.sinsin.project.model.BacSy;
import app.project.sinsin.project.model.NhatKy;
import app.project.sinsin.project.tab2.BacSyAdapter;

/**
 * Created by SINSIN on 5/10/2017.
 */

public class Tab3NhatKy extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
//        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        //xu ly su kien here

        ArrayList<NhatKy> listNhatKy = new ArrayList<>();
        listNhatKy.add(new NhatKy(1, "Baiviet1","Baiviet1",null,"drawable/logo"));
        listNhatKy.add(new NhatKy(1, "Baiviet1","Baiviet1",null,"drawable/logo"));
        listNhatKy.add(new NhatKy(1, "Baiviet1","Baiviet1",null,"drawable/logo"));
        listNhatKy.add(new NhatKy(1, "Baiviet1","Baiviet1",null,"drawable/logo"));


        View rootView = inflater.inflate(R.layout.activity_tab3, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listViewNhatKy);
        NhatKyAdapter adapter = new NhatKyAdapter(rootView.getContext(), R.layout.listview_nhatky, listNhatKy);
        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
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
