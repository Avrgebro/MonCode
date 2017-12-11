package com.project.deb.cosmetics;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.project.deb.cosmetics.Fragments.ContactanosFragment;
import com.project.deb.cosmetics.Fragments.DisenosFragment;
import com.project.deb.cosmetics.Fragments.MainFragment;
import com.project.deb.cosmetics.Fragments.PresentacionFragment;
import com.project.deb.cosmetics.Fragments.RedesFragment;


public class MainActivity extends AppCompatActivity {

    private String[] drawerListViewItems;
    private ListView drawerListView;
    private DrawerLayout drawerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerListView = (ListView) findViewById(R.id.left_drawer);
        drawerlayout = (DrawerLayout) findViewById(R.id.drwrlayout);

        Fragment fragment = new MainFragment();
        inflateFragment(fragment);



        drawerListViewItems = getResources().getStringArray(R.array.Menu_entries);

        drawerListView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1,
                drawerListViewItems));

        drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectItem(i);

            }
        });

        drawerListView.setItemChecked(0, true);


        ImageView btnmenu = (ImageView) findViewById(R.id.btnMenu);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerlayout.openDrawer(Gravity.START);
            }
        });


    }

    private void selectItem(int pos){

        if(pos == 0){//presentacion
            Fragment frag = new MainFragment();
            inflateFragment(frag);
        }
        if(pos == 1){//disenos
            Fragment frag = new DisenosFragment();
            inflateFragment(frag);
        }
        if(pos == 2){//contactenos
            Fragment frag = new ContactanosFragment();
            inflateFragment(frag);
        }
        if(pos == 3){//redes
            Fragment frag = new RedesFragment();
            inflateFragment(frag);
        }
    }


    private void inflateFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainfrm, fragment);
            ft.commit();

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drwrlayout);
            drawer.closeDrawer(GravityCompat.START);
        }
    }



}
