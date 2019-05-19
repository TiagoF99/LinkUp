package com.example.pickup;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void loginAccount(View view) {

        String info = "";
        boolean found = false;
        for (int i=0; i < MainActivity.words.size(); i++) {
            if (MainActivity.viewing.getAllWords().get(i).getWord().startsWith(username.getText().toString())) {
                found = true;
                info = MainActivity.words.get(i).getWord();
            }
        }

        if (username.getText() == null | password.getText() == null) {
            Toast.makeText(this, "Fill in all the fields.", Toast.LENGTH_LONG).show();
        } else {
            if (found) {
                Intent intent = new Intent(this, SplashPage.class);
                intent.putExtra("info", info);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Username is not found.", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void toRegister(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
