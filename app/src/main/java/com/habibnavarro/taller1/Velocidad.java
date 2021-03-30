package com.habibnavarro.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Velocidad extends AppCompatActivity {

    TextView distancia, tiempo, velocidad;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidad);

        distancia = findViewById(R.id.inp_v_1);
        tiempo = findViewById(R.id.inp_v_2);
        velocidad = findViewById(R.id.valor_velocidad);



        calcular = findViewById(R.id.btn_cal_velocidad);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                velocidad.setText((Double.parseDouble(distancia.getText().toString()) + Double.parseDouble(tiempo.getText().toString()))+"");
            }
        });
    }
}