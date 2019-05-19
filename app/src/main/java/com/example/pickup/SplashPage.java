package com.example.pickup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SplashPage extends AppCompatActivity {

    private ImageView explore;
    private ImageView create;
    private ImageView plan;
    private ImageView account;

    String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);

        explore = findViewById(R.id.explore);
        create = findViewById(R.id.create);
        plan = findViewById(R.id.plan);
        account = findViewById(R.id.account);

        info = getIntent().getStringExtra("info");
    }

    public void exploreClicked(View view) {
        explore.setImageResource(R.drawable.exploreclicked);
        Intent intent = new Intent(this, explore.class);
        startActivity(intent);
    }

    public void createClicked(View view) {
        create.setImageResource(R.drawable.createeventclicked);
    }

    public void planClicked(View view) {
        plan.setImageResource(R.drawable.planeventclicked);
    }

    public void clickAccount(View view) {
        Intent intent = new Intent(this, UserAccount.class);
        intent.putExtra("info", info);
        startActivity(intent);
    }
}
