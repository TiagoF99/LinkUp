package com.example.pickup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class exploreInfo extends AppCompatActivity {

    String title;
    private TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_info);

        title = getIntent().getStringExtra("title");
        titleView = findViewById(R.id.title);

        titleView.setText(title);
    }

    public void joinEvent(View view) {
        Intent intent = new Intent(this, SplashPage.class);
        startActivity(intent);
    }
}
