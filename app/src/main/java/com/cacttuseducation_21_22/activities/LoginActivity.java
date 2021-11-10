package com.cacttuseducation_21_22.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cacttuseducation_21_22.R;

public class LoginActivity extends AppCompatActivity {
    EditText etEmailOrUsername, etPassword;
    Button btnLogin, btnOpenUrl, btnCallNum;

    public static final int REQUEST_CODE_MAIN_ACTIVITY = 1;

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
                        intent.putExtra("booleanKey", true);
                        intent.putExtra("username", "reskipaski");
                        startActivityForResult(intent, REQUEST_CODE_MAIN_ACTIVITY);
//                        finish();

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) {
            Toast.makeText(LoginActivity.this, "Data are null", Toast.LENGTH_SHORT).show();
            return;
        }

        if(requestCode == REQUEST_CODE_MAIN_ACTIVITY && resultCode == RESULT_OK){
            String result = data.getStringExtra("key");
            Toast.makeText(LoginActivity.this, "Result is: " + result, Toast.LENGTH_SHORT).show();
        }

    }
}