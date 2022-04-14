package com.example.hajjlottery.ui.about_developer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.hajjlottery.R;

public class AboutDeveloperActivity extends AppCompatActivity {
    AboutDeveloperViewModel aboutDeveloperViewModel;
    TextView about_developer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.about_developer);

        about_developer = findViewById(R.id.about_developer);
        aboutDeveloperViewModel = new ViewModelProvider(this).get(AboutDeveloperViewModel.class);
        aboutDeveloperViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                about_developer.setText(s);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}