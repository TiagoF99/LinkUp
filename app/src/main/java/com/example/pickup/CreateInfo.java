package com.example.pickup;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateInfo extends AppCompatActivity {

    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_info);

        name = findViewById(R.id.eventName);
    }

    public void createEvent(View view) {

        int lat = getIntent().getIntExtra("lat", 43);
        int longitude = getIntent().getIntExtra("long", -79);
        String data = name.getText().toString();

        final String database_info = lat + " " + longitude + " " + name;
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                MainActivity.viewing.insert(new Word(database_info));
            }
        });

        Intent intent = new Intent(this, SplashPage.class);
        startActivity(intent);
    }

    /*
    At this point, every time a person joins the event, the person who created the event gets a
    notification.
     */
}
