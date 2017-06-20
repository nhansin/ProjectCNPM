package app.project.sinsin.project.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import app.project.sinsin.project.R;
import app.project.sinsin.project.dao.BaiVietDao;
import app.project.sinsin.project.model.BaiViet;
import app.project.sinsin.project.tab3.NhatKyAdapter;

/**
 * Created by nhan-dev on 6/20/2017.
 */

public class FragmentList extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        BaiVietDao baiVietDao = new BaiVietDao();
        final ArrayList<BaiViet> listBaiViet = baiVietDao.dsDanhMucChucNang(2);
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listBaiViet1);
        BaiVietAdapter adapter = new BaiVietAdapter(rootView.getContext(), R.layout.listview_baiviet, listBaiViet);
        listView.setAdapter(adapter);


        return rootView;

    }
}
