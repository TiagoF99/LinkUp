package com.example.pickup;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateInfo extends AppCompatActivity {

    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_info);

        name = findViewById(R.id.eventName);
    }

    public void createEvent(View view) {

        double lat = getIntent().getDoubleExtra("lat", 43.5);
        double longitude = getIntent().getDoubleExtra("long", -79.2);
        String data = name.getText().toString();


        final String database_info = Double.toString(lat) + " " + Double.toString(longitude) + " " + data;
        AsyncTask.execute(() -> MainActivity.viewing.insert(new Word(database_info)));

        Intent intent = new Intent(this, SplashPage.class);

        Toast.makeText(this, "Event has been created!", Toast.LENGTH_LONG).show();

        startActivity(intent);
        finish();
    }

    /*
    At this point, every time a person joins the event, the person who created the event gets a
    notification.
     */
}
