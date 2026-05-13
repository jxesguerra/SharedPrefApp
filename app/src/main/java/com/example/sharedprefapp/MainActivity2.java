package com.example.sharedprefapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView tv1, tv2;
    Button btn_LOGOUT;
    private static final String myPreferences = "MyPrefs";
    private static final String name = "nameKey";
    private static final String password = "passKey";
    private static final String email = "emailKey";
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv1 = findViewById(R.id.Tv_Name);
        tv2 = findViewById(R.id.Tv_Email);
        btn_LOGOUT = findViewById(R.id.Logout);

        sharedPref = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);

        String SavedName = sharedPref.getString(name,null);
        String SavedEmail = sharedPref.getString(email,null);

        if(SavedName != null && SavedEmail !=null)
        {
            tv1.setText(" : " + SavedName);
            tv2.setText(" : " +SavedEmail);
        }
        btn_LOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.commit();

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity2.this,"LOG OUT", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}