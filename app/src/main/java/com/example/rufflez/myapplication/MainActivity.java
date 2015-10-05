package com.example.rufflez.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()){
                    case R.id.drawer_labels:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentView, new FloatingLabelsFragment()).commit();
                        break;
                    case R.id.drawer_fab:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentView, new FABLayoutFragment()).commit();
                        break;
                    case R.id.drawer_snackbar:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentView, new SnackBarFragment()).commit();
                        break;
                    case R.id.drawer_tabs:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.contentView, new TabsFragment()).commit();
                        Intent i = new Intent(MainActivity.this, TabsActivity.class);
                        startActivity(i);
                        break;
                    case R.id.drawer_coordinator:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contentView, new CoordinatorFragment()).commit();
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
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

        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
