package com.habibnavarro.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class geometria extends AppCompatActivity {

    TextView x1, y1, x2, y2, res1, res2;
    Button calcular;
    Spinner spinner;
    int valor= 0;
    double raiz = 0, pendiente = 0, r1 = 0, r2 = 0, r3 = 0, r4 = 0;
    String c1, c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometria);

        x1 = findViewById(R.id.nx1);
        y1 = findViewById(R.id.ny1);
        x2 = findViewById(R.id.nx2);
        y2 = findViewById(R.id.ny2);
        res1 = findViewById(R.id.resultado1);
        res2 = findViewById(R.id.resultado2);



        spinner = (Spinner) findViewById(R.id.spinner2);
        String[] items = new String[]{"Cuadrante","Pendiente","Distancia"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valor = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


        calcular = findViewById(R.id.btn_cal_geometria);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x1.length() == 0 || y1.length() == 0 || x2.length() == 0 || y2.length() == 0) {
                    Toast.makeText(getApplicationContext(),"Faltan casillas por rellenar", Toast.LENGTH_LONG).show();
                } else {
                    if (valor == 0){
                        if(Double.parseDouble(x1.getText().toString()) == 0 || Double.parseDouble(y1.getText().toString()) == 0){
                            c1 = "La coordenada (x1,y1) esta en medio de dos cuadrantes";
                        } else {
                            if (Double.parseDouble(x1.getText().toString()) > 0 && Double.parseDouble(y1.getText().toString()) > 0) {
                                c1 = "La coordenada (x1,y1) esta en el cuadrante 1";
                            }
                            if (Double.parseDouble(x1.getText().toString()) < 0 && Double.parseDouble(y1.getText().toString()) > 0) {
                                c1 = "La coordenada (x1,y1) esta en el cuadrante 2";
                            }
                            if (Double.parseDouble(x1.getText().toString()) < 0 && Double.parseDouble(y1.getText().toString()) < 0) {
                                c1 = "La coordenada (x1,y1) esta en el cuadrante 3";
                            }
                            if (Double.parseDouble(x1.getText().toString()) > 0 && Double.parseDouble(y1.getText().toString()) < 0) {
                                c1 = "La coordenada (x1,y1) esta en el cuadrante 4";
                            }
                        }
                        if (Double.parseDouble(x2.getText().toString()) == 0 || Double.parseDouble(y2.getText().toString()) == 0) {
                            c2 = "La coordenada (x2,y2) esta en medio de dos cuadrantes";
                        } else {
                            if (Double.parseDouble(x2.getText().toString()) > 0 && Double.parseDouble(y2.getText().toString()) > 0) {
                                c2 = "La coordenada (x2,y2) esta en el cuadrante 1";
                            }
                            if (Double.parseDouble(x2.getText().toString()) < 0 && Double.parseDouble(y2.getText().toString()) > 0) {
                                c2 = "La coordenada (x2,y2) esta en el cuadrante 2";
                            }
                            if (Double.parseDouble(x2.getText().toString()) < 0 && Double.parseDouble(y2.getText().toString()) < 0) {
                                c2 = "La coordenada (x2,y2) esta en el cuadrante 3";
                            }
                            if (Double.parseDouble(x2.getText().toString()) > 0 && Double.parseDouble(y2.getText().toString()) < 0) {
                                c2 = "La coordenada (x2,y2) esta en el cuadrante 4";
                            }
                        }
                        res1.setText(c1);
                        res2.setText(c2);
                    }
                    if (valor == 2) {
                        r1 = (Double.parseDouble(x2.getText().toString()) - Double.parseDouble(x1.getText().toString())) * (Double.parseDouble(x2.getText().toString()) - Double.parseDouble(x1.getText().toString()));
                        r2 = (Double.parseDouble(y2.getText().toString()) - Double.parseDouble(y1.getText().toString())) * (Double.parseDouble(y2.getText().toString()) - Double.parseDouble(y1.getText().toString()));
                        r3 = Math.sqrt(r1+r2);

                        res1.setText(String.valueOf(r3));
                        res2.setText("");
                    }
                    if (valor == 1){
                        if((Double.parseDouble(x2.getText().toString()) - Double.parseDouble(x1.getText().toString())) == 0){
                            res1.setText("No tiene pendiente");
                            res2.setText("");
                        } else {
                            pendiente = (Double.parseDouble(y2.getText().toString()) - Double.parseDouble(y1.getText().toString())) / (Double.parseDouble(x2.getText().toString()) - Double.parseDouble(x1.getText().toString()));
                            res1.setText(String.valueOf(pendiente));
                            res2.setText("");
                        }
                    }
                }
            }
        });


    }
}