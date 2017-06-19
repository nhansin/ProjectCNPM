package app.project.sinsin.project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import app.project.sinsin.project.model.Connection;
import app.project.sinsin.project.tab1.Tab1ChucNang;
import app.project.sinsin.project.tab2.Tab2BacSy;
import app.project.sinsin.project.tab3.Tab3NhatKy;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME="NhatKyBiBauDB2.sqlite";
    public static SQLiteDatabase database;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    TabLayout tabLayout;
    int icon[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database= Connection.initDatabase(this,DATABASE_NAME);
        int maBaiViet=2;
        Cursor cursor=database.rawQuery("SELECT * FROM BaiViet where maBaiViet=\"maBaiViet\"",null);
        cursor.moveToLast();
        Toast.makeText(this, cursor.getString(4), Toast.LENGTH_LONG).show();

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        icon= new int[]{R.drawable.content, R.drawable.contact, R.drawable.dialog};
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        setUpTabIcon();


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Tab1ChucNang tab1ChucNang = new Tab1ChucNang();
                    return tab1ChucNang;
                case 1:
                    Tab2BacSy tab2BacSy = new Tab2BacSy();
                    return tab2BacSy;
                case 2:
                    Tab3NhatKy tab3NhatKy = new Tab3NhatKy();
                    return tab3NhatKy;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "TAB 1";
//                case 1:
//                    return "TAB 2";
//                case 2:
//                    return "TAB 3";
//            }
//            return null;
//        }

    }
    public void setUpTabIcon(){
        tabLayout.getTabAt(0).setIcon(icon[0]);
        tabLayout.getTabAt(1).setIcon(icon[1]);
        tabLayout.getTabAt(2).setIcon(icon[2]);

    }
}
