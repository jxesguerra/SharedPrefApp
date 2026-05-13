package com.example.sharedprefapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Button bt;

    private static final String myPreferences = "MyPrefs";
    private static final String name = "nameKey";
    private static final String password = "passKey";
    private static final String email = "emailKey";
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et1 = findViewById(R.id.Name);
        et2 = findViewById(R.id.Password);
        et3 = findViewById(R.id.Email);

        bt = findViewById(R.id.Save);

        sharedPref = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        String savedName = sharedPref.getString(name, null);
        String savePassword = sharedPref.getString(password, null);
        String savedEmail = sharedPref.getString(email, null);

        if (savedName != null && savePassword != null && savedEmail != null ){
            Intent intent = new Intent(MainActivity.this , MainActivity2.class);
            startActivity(intent);
        }

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = et1.getText().toString();
                String pw = et2.getText().toString();
                String e = et3.getText().toString();

                SharedPreferences.Editor editor = sharedPref.edit();

                editor.putString(name , n);
                editor.putString(password, pw);
                editor.putString(email, e);
                editor.commit();

                Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this , "Thanks",Toast.LENGTH_LONG).show();
                finish();

            }
        });

    }
}