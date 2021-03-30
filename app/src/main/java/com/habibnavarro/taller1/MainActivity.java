package com.habibnavarro.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
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
    CheckBox ck_remember;
    CheckBox ck_terms_and_conditions;
    Button btn_submit;
    Button btn_register;
    TextView inp_username;
    TextView inp_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        users.add(new User("cforonda", "contraseña", "Cristian", "Foronda", "cforonda@gmail.com", "M"));
        users.add(new User("macuna", "contraseña", "Marlon", "Acuña", "macuna@gmail.com", "M"));
        users.add(new User("hnavarro", "contraseña", "Habib", "Navarro", "hnavarro@gmail.com", "M"));

        ck_remember = findViewById(R.id.ck_remember);
        ck_terms_and_conditions = findViewById(R.id.ck_terms_and_conditions);
        btn_submit = findViewById(R.id.btn_submit);
        btn_register = findViewById(R.id.btn_register);
        inp_username = findViewById(R.id.inp_username);
        inp_password = findViewById(R.id.inp_password);

        load_preferences();

        ck_terms_and_conditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                btn_submit.setEnabled(ck_terms_and_conditions.isChecked());
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = inp_username.getText().toString();
                String password = inp_password.getText().toString();

                if (username.length() == 0 )
                    Toast.makeText(getApplicationContext(), "Usuario requerido", Toast.LENGTH_LONG).show();
                else if (password.length() == 0 )
                    Toast.makeText(getApplicationContext(), "Contraseña requerida", Toast.LENGTH_LONG).show();
                else if (validate_user(username, password)) {
                    if (ck_remember.isChecked())
                        save_preferences(username, password);
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                }
                else
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña Incorrecta", Toast.LENGTH_LONG).show();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }

    private void save_preferences(String username, String password) {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putBoolean("remember", ck_remember.isChecked());
        editor.putBoolean("terms_and_conditions", ck_terms_and_conditions.isChecked());
        editor.commit();
    }

    private void load_preferences() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        inp_username.setText(preferences.getString("username", ""));
        inp_password.setText(preferences.getString("password", ""));
        ck_remember.setChecked(preferences.getBoolean("remember", false));
        ck_terms_and_conditions.setChecked(preferences.getBoolean("terms_and_conditions", false));
        btn_submit.setEnabled(ck_terms_and_conditions.isChecked());
    }

    private boolean validate_user(String username, String password) {
        for (User u:users)
            if (u.validate(username, password))
                return true;
        return  false;
    }
}