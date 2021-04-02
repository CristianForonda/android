package com.habibnavarro.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class OlvidarContrasenaActivity extends AppCompatActivity {

    TextView inp_email, inp_code;
    Button btn_send_code, btn_validar;
    int code = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidar_contrasena);

        inp_email = findViewById(R.id.inp_ovl_email);
        inp_code = findViewById(R.id.inp_ovl_code);
        btn_send_code = findViewById(R.id.btn_ovl_send_code);
        btn_validar = findViewById(R.id.btn_ovl_validar);

        btn_send_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inp_email.getText().toString().length() == 0)
                    Toast.makeText(getApplicationContext(), "Ingrese un correo válido:", Toast.LENGTH_SHORT).show();
                else {
                    code = new Random().nextInt((9999 - 1111) + 1) + 1111;
                    Toast.makeText(getApplicationContext(), "Código:" + code, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(inp_code.getText().toString()) != code)
                    Toast.makeText(getApplicationContext(), "Código no válido", Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(OlvidarContrasenaActivity.this, RecuperarPassActivity.class));
            }
        });
    }
}