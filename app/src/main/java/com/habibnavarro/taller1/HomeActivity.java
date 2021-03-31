package com.habibnavarro.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    Button fisica, geometria1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fisica = findViewById(R.id.btn_fisica);
        fisica.setOnClickListener(this);
        geometria1 = findViewById(R.id.btn_geometria);
        geometria1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_fisica) {
            Intent i = new Intent(getApplicationContext(), MainActivityFisica.class);
            startActivity(i);
        } else if (v.getId() == R.id.btn_geometria) {
            Intent j = new Intent(getApplicationContext(), geometria.class);
            startActivity(j);
        }
    }
}