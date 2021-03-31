package com.habibnavarro.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityFisica extends AppCompatActivity implements View.OnClickListener{
    Button velocidad, fuerza, voltaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fisica);

        velocidad =  findViewById(R.id.btn_velocidad);
        velocidad.setOnClickListener(this);
        fuerza =  findViewById(R.id.btn_fuerza);
        fuerza.setOnClickListener(this);
        voltaje =  findViewById(R.id.btn_voltaje);
        voltaje.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_velocidad){
            Intent i = new Intent(getApplicationContext(), Velocidad.class);
            startActivity(i);
        }
        if (v.getId() == R.id.btn_fuerza){
            Intent j = new Intent(getApplicationContext(), Fuerza.class);
            startActivity(j);
        }
        if (v.getId() == R.id.btn_voltaje){
            Intent i = new Intent(getApplicationContext(), Voltaje.class);
            startActivity(i);
        }
    }
}