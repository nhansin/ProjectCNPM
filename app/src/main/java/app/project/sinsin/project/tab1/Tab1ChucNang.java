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

import app.project.sinsin.project.R;
import app.project.sinsin.project.content.ListBaiViet;

/**
 * Created by SINSIN on 5/10/2017.
 */

public class Tab1ChucNang extends Fragment {


    GridView gridView;
    GridViewAdapter adapter;
    String[] title = {"Thai kỳ", "Thực phẩm", "Món ăn", "Nhóm chất", "Lịch khám thai", "Cần mua - Cần làm", "Đọc truyện", "Hỏi đáp",};
    int[] logo = {R.drawable.thai_ky, R.drawable.thuc_pham, R.drawable.mon_an_3, R.drawable.nhom_chat, R.drawable.lich_kham_thai, R.drawable.can_mua, R.drawable.truyen, R.drawable.question};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_tab1, container, false);
        gridView = (GridView) rootView.findViewById(R.id.gridView);
        adapter = new GridViewAdapter(rootView.getContext(), title, logo);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent i = new Intent(getActivity(), ListBaiViet.class);
                        i.putExtra("id", position);
                        startActivity(i);
                        break;
                    default:
                        break;
                }
            }
        });

        return rootView;
    }
}
