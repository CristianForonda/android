package com.habibnavarro.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Spinner register_sex;
    TextView register_first_name;
    TextView register_last_name;
    TextView register_email;
    TextView register_username;
    TextView register_password;
    TextView register_confirm_password;
    Button btn_back;
    Button btn_create_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_sex = findViewById(R.id.register_sex);
        register_first_name = findViewById(R.id.register_first_name);
        register_last_name = findViewById(R.id.register_last_name);
        register_email = findViewById(R.id.register_email);
        register_username = findViewById(R.id.register_username);
        register_password = findViewById(R.id.register_password);
        btn_create_user = findViewById(R.id.btn_create_user);
        register_confirm_password = findViewById(R.id.register_confirm_password);
        btn_back = findViewById(R.id.btn_back);

        btn_create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first_name = register_first_name.getText().toString();
                String email = register_last_name.getText().toString();
                String last_name = register_email.getText().toString();
                String username = register_username.getText().toString();
                String password = register_password.getText().toString();
                String confirm_password = register_confirm_password.getText().toString();

                if (first_name.length() == 0)
                    Toast.makeText(getApplicationContext(), "Nombres requerido", Toast.LENGTH_LONG).show();

                else if (last_name.length() == 0)
                    Toast.makeText(getApplicationContext(), "Apellidos requerido", Toast.LENGTH_LONG).show();

                else if (email.length() == 0)
                    Toast.makeText(getApplicationContext(), "Correo requerido", Toast.LENGTH_LONG).show();

                else if (username.length() == 0)
                    Toast.makeText(getApplicationContext(), "Usuario requerido", Toast.LENGTH_LONG).show();

                else if (password.length() == 0)
                    Toast.makeText(getApplicationContext(), "Contraseña requerida", Toast.LENGTH_LONG).show();

                else if (password.length() < 6)
                    Toast.makeText(getApplicationContext(), "La contraseña debe se tener por lo menos de 6 caracteres", Toast.LENGTH_LONG).show();

                else if (!password.equals(confirm_password))
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();

                else {

                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}