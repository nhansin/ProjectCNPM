package app.project.sinsin.project.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import app.project.sinsin.project.R;

public class Activity_BaiViet extends AppCompatActivity {
    int maThaiKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        Intent intent = getIntent();
        maThaiKy = intent.getIntExtra("maBaiViet", 0);




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            Bundle bundle = new Bundle();
            @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;
                switch (item.getItemId()) {


                    case R.id.action_item2:
//                         bundle = new Bundle();
                        bundle.putInt("maDanhMuc", 2);
//                        ItemTwoFragment fragobj1 = new ItemTwoFragment();
//                        fragobj1.setArguments(bundle);
//                        selectedFragment = fragobj1;
                        selectedFragment = ItemTwoFragment.newInstance();
                        break;
                    case R.id.action_item3:
                        bundle.putInt("maDanhMuc", 3);
//                        bundle = new Bundle();
//                        bundle.putInt("maThaiKy", maThaiKy);
//                        ItemThreeFragment fragobj2 = new ItemThreeFragment();
//                        fragobj2.setArguments(bundle);
//                        selectedFragment = fragobj2;
                        selectedFragment = ItemThreeFragment.newInstance();
                        break;
                    case R.id.action_item4:
//                         bundle = new Bundle();
//                        bundle.putInt("maThaiKy", maThaiKy);
//                        ItemFourFragment fragobj3 = new ItemFourFragment();
//                        fragobj3.setArguments(bundle);
//                        selectedFragment = fragobj3;
                        selectedFragment = ItemFourFragment.newInstance();

                        break;
                    case R.id.action_item1:
//                        Bundle bundle1 = new Bundle();
//                        bundle1.putInt("maThaiKy1", maThaiKy);
                        // ItemOneFragment fragobj = new ItemOneFragment();
                        selectedFragment = ItemOneFragment.newInstance();
                        //fragobj.setArguments(bundle1);
                        //selectedFragment = fragobj;
                        break;

                }

                bundle.putInt("maThaiKy", maThaiKy);

                selectedFragment.setArguments(bundle);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        //Manually displaying the first fragment - one time only
        Bundle bundle = new Bundle();
        bundle.putInt("maThaiKy", maThaiKy);
        Fragment selectedFragment = ItemOneFragment.newInstance();
        selectedFragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, selectedFragment);
        transaction.commit();
    }
}
