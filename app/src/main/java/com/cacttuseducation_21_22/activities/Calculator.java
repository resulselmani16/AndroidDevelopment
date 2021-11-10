package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cacttuseducation_21_22.R;

public class Calculator extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonPoint, buttonClear, buttonEqual;
    EditText editText;
    float valueOne, valueTwo;

    boolean isPlus, isMinus, isMultiplication, isDivision;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        findViews();
        onCLickListeners();

    }

    private void onCLickListeners() {
        button0.setOnClickListener(view -> {
            editText.setText(editText.getText() + "0");
        });
        button1.setOnClickListener(view -> {
            editText.setText(editText.getText() + "1");
        });
        button2.setOnClickListener(view -> {
            editText.setText(editText.getText() + "2");
        });
        button3.setOnClickListener(view -> {
            editText.setText(editText.getText() + "3");
        });
        button4.setOnClickListener(view -> {
            editText.setText(editText.getText() + "4");
        });
        button5.setOnClickListener(view -> {
            editText.setText(editText.getText() + "5");
        });
        button6.setOnClickListener(view -> {
            editText.setText(editText.getText() + "6");
        });
        button7.setOnClickListener(view -> {
            editText.setText(editText.getText() + "7");
        });
        button8.setOnClickListener(view -> {
            editText.setText(editText.getText() + "8");
        });
        button9.setOnClickListener(view -> {
            editText.setText(editText.getText() + "9");
        });

        buttonPlus.setOnClickListener(view ->{
            if(editText.getText().toString().length()>0){
                valueOne = Float.parseFloat(editText.getText().toString());
                isPlus = true;
                editText.setText(null);
            }
        });
        buttonMinus.setOnClickListener(view ->{
            if(editText.getText().toString().length()>0){
                valueOne = Float.parseFloat(editText.getText().toString());
                isMinus = true;
                editText.setText(null);
            }
        });
        buttonMultiply.setOnClickListener(view ->{
            if(editText.getText().toString().length()>0){
                valueOne = Float.parseFloat(editText.getText().toString());
                isMultiplication = true;
                editText.setText(null);
            }
        });
        buttonDivide.setOnClickListener(view ->{
            if(editText.getText().toString().length()>0){
                valueOne = Float.parseFloat(editText.getText().toString());
                isDivision = true;
                editText.setText(null);
            }
        });
        buttonPoint.setOnClickListener(view ->{
            editText.setText(editText.getText() + ".");
        });
        buttonClear.setOnClickListener(view ->{
            editText.setText("");
        });
        buttonEqual.setOnClickListener(view ->{
            valueTwo = Float.parseFloat(editText.getText().toString());

            if(isPlus){
                editText.setText(valueOne + valueTwo + "");
                isPlus = false;
            } else if(isMinus){
                editText.setText(valueOne - valueTwo + "");
                isMinus = false;
            } else if(isMultiplication){
                editText.setText(valueOne * valueTwo + "");
                isMultiplication = false;
            } else if(isDivision){
                editText.setText(valueOne / valueTwo + "");
                isDivision = false;
            }
        });
    }

    private void findViews() {
        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonPlus = findViewById(R.id.btnPlus);
        buttonMinus = findViewById(R.id.btnMinus);
        buttonMultiply = findViewById(R.id.btnMultiply);
        buttonDivide = findViewById(R.id.btnDivide);
        buttonClear = findViewById(R.id.btnClear);
        buttonPoint = findViewById(R.id.btnPoint);
        buttonEqual = findViewById(R.id.equalsTo);
        editText = findViewById(R.id.result);
    }
}