package com.habibnavarro.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fuerza extends AppCompatActivity {

    TextView fuerza, masa, aceleracion;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuerza);

        masa = findViewById(R.id.val_masa);
        aceleracion = findViewById(R.id.val_aceleracion);
        fuerza = findViewById(R.id.val_fuerza);

        calcular = findViewById(R.id.btn_cal_fuerza);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuerza.setText((Double.parseDouble(masa.getText().toString()) * Double.parseDouble(aceleracion.getText().toString()))+"");
            }
        });
    }}