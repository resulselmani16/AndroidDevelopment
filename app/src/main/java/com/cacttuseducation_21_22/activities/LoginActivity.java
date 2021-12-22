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
    Button btnLogin, btnOpenUrl, btnCallNumber;

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

                String correctUsername = "cacttus";
                String correctPassword = "12345678";

                if (emailOrUsername.length() > 6 && password.length() > 6){
                    if (emailOrUsername.equals(correctUsername) && password.equals(correctPassword)){
                        // open main activity
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("booleanKey",true);
                        intent.putExtra("stringKey","CacttusEducation");
                        startActivityForResult(intent,REQUEST_CODE_MAIN_ACTIVITY);
                       // finish();
                    }else {
                        Toast.makeText(LoginActivity.this, getString(R.string.username_or_password_wrong), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(LoginActivity.this, getString(R.string.please_fill_all_fields), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.google_url)));
                startActivity(intent);

            }
        });

        btnCallNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.phone_number)));
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        etEmailOrUsername = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnOpenUrl = findViewById(R.id.btnOpenUrl);
        btnCallNumber = findViewById(R.id.btnCallNumber);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null){
            Toast.makeText(LoginActivity.this, "Data are null", Toast.LENGTH_SHORT).show();
            return;
        }

        if (requestCode == REQUEST_CODE_MAIN_ACTIVITY && resultCode == RESULT_OK){
            int result = data.getIntExtra("key",-1);
            Toast.makeText(LoginActivity.this, "Result is: " + result, Toast.LENGTH_SHORT).show();
        }

    }
}