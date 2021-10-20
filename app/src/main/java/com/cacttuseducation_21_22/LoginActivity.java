package com.cacttuseducation_21_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class LoginActivity extends AppCompatActivity {
    EditText etEmailOrUsername, etPassword;
    Button btnLogin, btnOpenUrl, btnCallNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
        onClickListeners();

    }

    private void onClickListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailOrUsername = etEmailOrUsername.getText().toString();
                String password = etPassword.getText().toString();
                String correctUsername = "reskipaski";
                String correctPassword = "12345678";

                if (emailOrUsername.length() > 5 && password.length() > 6) {
                    if (etEmailOrUsername.getText().toString().equals(correctUsername) && etPassword.getText().toString().equals(correctPassword)) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                        Toast.makeText(LoginActivity.this, getString(R.string.welcome_user), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, getString(R.string.username_or_password_wrong), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, getString(R.string.fill_fields), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });

        btnCallNum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + getString(R.string.MyPhoneNumber)));
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        etEmailOrUsername = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnOpenUrl = findViewById(R.id.btnOpenUrl);
        btnCallNum = findViewById(R.id.callNum);
    }
}