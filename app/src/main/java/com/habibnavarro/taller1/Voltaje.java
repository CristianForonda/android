package com.habibnavarro.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Voltaje extends AppCompatActivity {

    TextView amperaje, resistencia1, resistencia2, resistencia3, voltaje;
    int valor = 0;
    Button calcula;
    Spinner spinner;
    CheckBox ck_voltajeparalelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voltaje);

        amperaje =findViewById(R.id.val_amperaje);
        resistencia1 =findViewById(R.id.val_resistencia1);
        resistencia2 =findViewById(R.id.val_resistencia2);
        resistencia3 =findViewById(R.id.val_resistencia3);
        voltaje =findViewById(R.id.val_voltaje);
        ck_voltajeparalelo = findViewById(R.id.checkBox);

        spinner = (Spinner) findViewById(R.id.spinner);
        Integer[] items = new Integer[]{2,3};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valor = items[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


        calcula = findViewById(R.id.btn_cal_voltaje);
        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_cal_voltaje) {
                    if (amperaje.length() == 0 || resistencia1.length() == 0 || resistencia2.length() == 0){
                        Toast.makeText(getApplicationContext(),"Faltan casillas por rellenar",Toast.LENGTH_LONG).show();
                        voltaje.setText("");
                    } else {
                        if (ck_voltajeparalelo.isChecked()){
                            if (valor == 2 ){
                                voltaje.setText((Double.parseDouble(amperaje.getText().toString()) * (1/Double.parseDouble(resistencia1.getText().toString()) + 1/Double.parseDouble(resistencia2.getText().toString())))+"");
                            }else{
                                if (resistencia3.length() == 0){
                                    Toast.makeText(getApplicationContext(),"Faltan casillas por rellenar",Toast.LENGTH_LONG).show();
                                    voltaje.setText("");
                                }else{
                                    voltaje.setText((Double.parseDouble(amperaje.getText().toString()) * (1/Double.parseDouble(resistencia1.getText().toString()) + 1/Double.parseDouble(resistencia2.getText().toString()) + 1/Double.parseDouble(resistencia3.getText().toString())))+"");
                                }
                            }
                        } else {
                            if (valor == 2 ){
                                voltaje.setText((Double.parseDouble(amperaje.getText().toString()) * (Double.parseDouble(resistencia1.getText().toString()) + Double.parseDouble(resistencia2.getText().toString())))+"");
                            }else{
                                if(resistencia3.length() == 0){
                                    Toast.makeText(getApplicationContext(),"Faltan casillas por rellenar",Toast.LENGTH_LONG).show();
                                    voltaje.setText("");
                                } else {
                                    voltaje.setText((Double.parseDouble(amperaje.getText().toString()) * (Double.parseDouble(resistencia1.getText().toString()) + Double.parseDouble(resistencia2.getText().toString()) + Double.parseDouble(resistencia3.getText().toString())))+"");
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}