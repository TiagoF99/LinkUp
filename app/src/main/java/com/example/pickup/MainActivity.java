package com.example.pickup;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<com.example.pickup.Word> words;
    private WordViewModel viewing;

    private EditText username;
    private EditText password;
    private EditText age;
    private EditText gender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        age = findViewById(R.id.Age);
        gender = findViewById(R.id.Gender);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                viewing = new WordViewModel(getApplication());
                words = viewing.getAllWords();
            }
        });
    }


    public void registerAccount(View view) {

//        boolean found = false;
//        for (int i=0; i < words.size(); i++) {
//            if (words.get(i).getWord().startsWith(username.getText().toString())) {
//                found = true;
//            }
//        }

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                viewing.insert(new Word("tiago"));
            }
        });


        Toast.makeText(this, words.toString(), Toast.LENGTH_LONG).show();

//        final String new_person = username + " " + password + " " + age + " " + gender;
//        if (!found) {
//            AsyncTask.execute(new Runnable() {
//                @Override
//                public void run() {
//                    viewing.insert(new Word(new_person));
//                }
//            });
//            Intent intent = new Intent(this, SplashPage.class);
//            intent.putExtra("info", new_person);
//            startActivity(intent);
//        } else {
//            Toast toast = new Toast(this);
//            toast.setText("Username is already taken.");
//            toast.show();
//        }


    }

    public void toLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
