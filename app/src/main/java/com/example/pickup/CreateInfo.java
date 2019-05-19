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

        int lat = getIntent().getIntExtra("lat", 43);
        int longitude = getIntent().getIntExtra("long", -79);
        String data = name.getText().toString();

        final String database_info = lat + " " + longitude + " " + data;
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
