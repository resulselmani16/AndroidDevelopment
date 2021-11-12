package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.cacttuseducation_21_22.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnLoginActivity, btnCalculator, btnFunFacts, btnListView, btnPersonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoginActivity = findViewById(R.id.btnLoginActivity);
        btnCalculator = findViewById(R.id.btnCalculatorActivity);
        btnFunFacts = findViewById(R.id.btnFactsActivity);
        btnListView = findViewById(R.id.btnListView);
        btnPersonList = findViewById(R.id.btnPersonList);

    btnLoginActivity.setOnClickListener(v -> {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    });
    btnCalculator.setOnClickListener(v -> {
        Intent intent = new Intent(MainActivity.this, Calculator.class);
        startActivity(intent);
    });
    btnFunFacts.setOnClickListener(v -> {
        Intent intent = new Intent(MainActivity.this, FunFactsActivity.class);
        startActivity(intent);
    });
    btnListView.setOnClickListener(v -> {
        Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
        startActivity(intent);
    });
    btnPersonList.setOnClickListener(v ->{
        Intent intent = new Intent(MainActivity.this, PersonActivity.class);
        startActivity(intent);
    });

        System.out.println("metoda e thirrur eshte: onCreate");

        Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
        if(getIntent().getExtras() != null){
            boolean value = getIntent().getBooleanExtra("booleanKey", false);
            System.out.println("Vlera ne ardhje eshte: " + value);
            String username = getIntent().getStringExtra("username");
            System.out.println("Vlera ne ardhje eshte: " + username);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("metoda e thirrur eshte: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("metoda e thirrur eshte: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("metoda e thirrur eshte: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("metoda e thirrur eshte: onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("metoda e thirrur eshte: onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("metoda e thirrur eshte: onDestroy");
    }

    @Override
    public void onBackPressed() {
      //  super.onBackPressed();
//        showAlertDialog();
        //showTimePickerDialog();
       // showProgressDialog();
        Intent intent = getIntent();
        intent.putExtra("key", "ReskiPaski");
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    private void showProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("First Progress Dialog");
        progressDialog.setMessage("Loading");
        progressDialog.setButton(Dialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Yes clicked", Toast.LENGTH_SHORT).show();
            }
        });
        progressDialog.show();

    }

    private void showTimePickerDialog() {
        final int hour, minute;
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, "Ora qe keni zgjedhur eshte: " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
            }
        },hour,minute,true);
        timePickerDialog.show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("First Dialog");
        alertDialogBuilder.setMessage("Do you want to close the app?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}