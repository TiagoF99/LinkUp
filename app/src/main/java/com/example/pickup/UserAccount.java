package com.example.pickup;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class UserAccount extends AppCompatActivity {



    private TextView name;
    private TextView age;
    private TextView gender;
    private TextView description;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        String info = getIntent().getStringExtra("info");

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.Gender);
        description = findViewById(R.id.description);

        String[] thing = info.split(" ");

        name.setText(thing[0]);
        age.setText("Age:" + thing[3]);
        gender.setText("Gender:" + thing[4]);
    }



}
