package com.habibnavarro.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RecuperarPassActivity extends AppCompatActivity {
    TextView inp_new_pass, inp_new_pass2;
    Button btn_new_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_pass);

        inp_new_pass = findViewById(R.id.inp_new_pass);
        inp_new_pass2 = findViewById(R.id.inp_new_pass2);
        btn_new_pass = findViewById(R.id.btn_new_pass);

        btn_new_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inp_new_pass.getText().toString().length() < 6)
                    Toast.makeText(getApplicationContext(), "La contraseña debe tener por lo menos 6 caracteres", Toast.LENGTH_SHORT).show();
                if (inp_new_pass.getText().toString().equals(inp_new_pass2.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Contraseña restablecida", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RecuperarPassActivity.this, MainActivity.class));
                }

            }
        });
    }
}