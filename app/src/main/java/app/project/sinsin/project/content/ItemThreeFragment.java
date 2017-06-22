package app.project.sinsin.project.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import app.project.sinsin.project.R;
import app.project.sinsin.project.dao.BaiVietDao;
import app.project.sinsin.project.dao.DanhMucChucNangDao;
import app.project.sinsin.project.model.BaiViet;

/**
 * Created by nhan-dev on 6/20/2017.
 */

public class ItemThreeFragment extends Fragment {
    SearchView searchView;
    Toolbar toolbar;
    ListView listView;
    ArrayList<BaiViet> baiViets;
    BaiVietAdapter baiVietAdapter;


    public static ItemThreeFragment newInstance() {
        ItemThreeFragment fragment = new ItemThreeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int maThaiKy =getArguments().getInt("maThaiKy");
        int maDanhMuc =getArguments().getInt("maDanhMuc");
        View rootView= inflater.inflate(R.layout.activity_list_bai_viet, container, false);


        BaiVietDao baiVietDao = new BaiVietDao();



        baiViets= baiVietDao.baiVietThucPham_ThaiKy(maThaiKy,maDanhMuc);

        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);


        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity) getActivity()).onBackPressed();
            }
        });
        DanhMucChucNangDao danhMucChucNangDao=new DanhMucChucNangDao();
        toolbar.setTitle("Món Ăn "+baiVietDao.chiTietBaiViet(maThaiKy).getTieuDe());
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        listView = (ListView) rootView.findViewById(R.id.listBaiViet);
        baiVietAdapter = new BaiVietAdapter(getActivity(), R.layout.activity_list_bai_viet, baiViets);
        listView.setAdapter(baiVietAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ChiTietBaiViet.class);

                intent.putExtra("maBaiViet", baiViets.get(position).getMaBaiViet());
                startActivity(intent);
            }
        });
        searchView = (SearchView)rootView.findViewById(R.id.search_view);
        return rootView;
    }
}