package com.example.hajjlottery.ui;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hajjlottery.R;
import com.example.hajjlottery.ui.about_council.AboutCouncilActivity;
import com.example.hajjlottery.ui.about_developer.AboutDeveloperActivity;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawer;
    long time;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer= findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_rate, R.id.nav_share, R.id.nav_more_app, R.id.nav_council, R.id.nav_developer)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        switch (menuItem.getItemId()) {
            case R.id.nav_share:
                // do share intent
                String title = "تطبيق قرعة الحج - السودان" ;
                String link = "https://play.google.com/store/apps/details?id=com.example.hajjlottery";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, title + "\n" + link);
                startActivity(Intent.createChooser(intent,"Share Using"));
                drawer.closeDrawers(); // close nav bar
                break;

            case R.id.nav_rate:
                // do rate intent
                Intent rate = new Intent(Intent.ACTION_VIEW);
                rate.setData(Uri.parse("market://details?id="+getPackageName()));
                startActivity(rate);
                drawer.closeDrawers(); // close nav bar
                break;

            case R.id.nav_more_app:
                // do rate intent
                Intent more_app = new Intent(Intent.ACTION_VIEW);
                more_app.setData(Uri.parse("https://play.google.com/store/apps/developer?id=youraddress"));
                startActivity(more_app);
                drawer.closeDrawers(); // close nav bar
                break;

            case R.id.nav_council:
                // do home intent
                //getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new AboutCouncilFragment()).commit();
                startActivity(new Intent(MainActivity.this, AboutCouncilActivity.class));
                drawer.closeDrawers(); // close nav bar
                break;

            case R.id.nav_developer:
                // do home intent
                //getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new AboutCouncilFragment()).commit();
                startActivity(new Intent(MainActivity.this, AboutDeveloperActivity.class));
                drawer.closeDrawers(); // close nav bar
                break;
        }
        drawer.closeDrawers(); // close nav bar
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(time+2000>System.currentTimeMillis()) {
                super.onBackPressed();
            }
            else
            {
                Toast toast = new Toast(getApplicationContext());
                TextView tv=new TextView(MainActivity.this);
                tv.setText(R.string.confirm_exit);
                tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tv.setPadding(50,20,50,20);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(16);
                toast.setView(tv);
                toast.show();
            }
        }
        time=System.currentTimeMillis();
    }
}