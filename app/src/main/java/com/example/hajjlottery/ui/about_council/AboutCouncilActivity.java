package com.example.hajjlottery.ui.about_council;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.hajjlottery.R;

public class AboutCouncilActivity extends AppCompatActivity {
    AboutCouncilViewModel aboutCouncilViewModel;
    TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_council);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.about_council);

        about = findViewById(R.id.about_council);
        aboutCouncilViewModel = new ViewModelProvider(this).get(AboutCouncilViewModel.class);
        aboutCouncilViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                about.setText(s);
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