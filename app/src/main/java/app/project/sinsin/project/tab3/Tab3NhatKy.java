package app.project.sinsin.project.tab3;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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
    NhatKyDao nhatKyDao;
    ArrayList<NhatKy> listNhatKy;
    NhatKyAdapter adapter;

    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        nhatKyDao = new NhatKyDao();
        listNhatKy = nhatKyDao.danhSachNhatKy();


        View rootView = inflater.inflate(R.layout.activity_tab3, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listViewNhatKy);
        adapter = new NhatKyAdapter(rootView.getContext(), R.layout.listview_nhatky, listNhatKy);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ChiTietNhatKy.class);
                intent.putExtra("maNhatKy", listNhatKy.get(position).getMaNhatKy());
                startActivity(intent);

            }
        });

        registerForContextMenu(listView);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflate = getActivity().getMenuInflater();
        inflate.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
//        return super.onContextItemSelected(item);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
//            case R.id.idSua:
//
//                break;
            case R.id.idXoa:
                AlertDialog diaBox = AskOption(info.position);

                diaBox.show();
                diaBox.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLUE);
                diaBox.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE);

                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    private AlertDialog AskOption(final int positionToDelete) {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(getActivity())
                //set message, title, and icon
                .setTitle("Xóa nhật ký")
                .setMessage("Bạn có chắc chắn muốn xóa nhật ký này không?")

//                .setIcon(R.drawable.delete)

                .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        //your deleting code
                        listNhatKy.remove(positionToDelete);
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }

                })

                .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;

    }
}