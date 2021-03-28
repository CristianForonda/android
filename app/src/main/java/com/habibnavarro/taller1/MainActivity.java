package com.habibnavarro.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<User> users = new ArrayList<User>();
    CheckBox ck_terms_and_conditions;
    Button btn_submit;
    TextView inp_username;
    TextView inp_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users.add(new User("cforonda", "contraseña", "Cristian", "Foronda"));
        users.add(new User("macuna", "contraseña", "Marlon", "Acuña"));
        users.add(new User("hnavarro", "contraseña", "Habib", "Navarro"));

        ck_terms_and_conditions = findViewById(R.id.ck_terms_and_conditions);
        btn_submit = findViewById(R.id.btn_submit);
        inp_username = findViewById(R.id.inp_username);
        inp_password = findViewById(R.id.inp_password);

        ck_terms_and_conditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                btn_submit.setEnabled(ck_terms_and_conditions.isChecked());
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inp_username.getText().toString().length() == 0 )
                    Toast.makeText(getApplicationContext(), "Usuario requerido", Toast.LENGTH_LONG).show();
                else if (inp_password.getText().toString().length() == 0 )
                    Toast.makeText(getApplicationContext(), "Contraseña requerida", Toast.LENGTH_LONG).show();
                else if (validate_user(inp_username.getText().toString(), inp_password.getText().toString()))
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                else
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña Incorrecta", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validate_user(String username, String password) {
        for (User u:users) {
            if (u.validate(username, password))
                return true;
        }
        return  false;
    }
}