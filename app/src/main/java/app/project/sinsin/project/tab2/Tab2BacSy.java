package app.project.sinsin.project.tab2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import app.project.sinsin.project.R;
import app.project.sinsin.project.model.BacSy;

/**
 * Created by SINSIN on 5/10/2017.
 */


public class Tab2BacSy extends Fragment {

    ArrayList<BacSy> listBacSy;
    ListView listView;
    BacSyAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listBacSy = new ArrayList<>();
        listBacSy.add(new BacSy("BacSy1", "0000xxxx", "jffffff@mgail", "drawable/logo"));
        listBacSy.add(new BacSy("BacSy2", "0000xxxx", "jffffff@mgail", "drawable/logo"));
        listBacSy.add(new BacSy("BacSy3", "0000xxxx", "jffffff@mgail", "drawable/logo"));
        listBacSy.add(new BacSy("BacSy4", "0000xxxx", "jffffff@mgail", "drawable/logo"));

        View rootView = inflater.inflate(R.layout.activity_tab2, container, false);
        listView = (ListView) rootView.findViewById(R.id.listViewBacSy);
        adapter = new BacSyAdapter(rootView.getContext(), R.layout.listview_bacsy, listBacSy);
        listView.setAdapter(adapter);

        return rootView;
    }
}
