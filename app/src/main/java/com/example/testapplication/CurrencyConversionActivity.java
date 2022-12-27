package com.example.testapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;


public class CurrencyConversionActivity extends AppCompatActivity {

    TextView txtUserName,txtPhoneNo,txtCurrentDate,txtCurrentTime,txtAmount;
    EditText edtAmount;
    Button btnConvert;

    String user,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_conversion);

        initViews();
        extractData();
        initListeners();
    }

    public void initViews(){
        txtUserName = findViewById(R.id.txtUserName);
        txtPhoneNo = findViewById(R.id.txtPhoneNo);
        txtCurrentDate = findViewById(R.id.txtCurrentDate);
        txtCurrentTime = findViewById(R.id.txtCurrentTime);
        txtAmount = findViewById(R.id.txtAmount);
        edtAmount = findViewById(R.id.edtAmount);
        btnConvert = findViewById(R.id.btnConvert);
    }

    public void extractData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        user = bundle.getString("user");
        phone = bundle.getString("phone");

        txtUserName.setText(user);
        txtPhoneNo.setText(phone);
    }

    public void initListeners(){
        btnConvert.setOnClickListener(new BtnConvertClickListener());
        txtCurrentDate.setOnClickListener(new TxtCurrentDateClickListener());
        txtCurrentTime.setOnClickListener(new txtCurrentTimeClickListener());
    }

    class TxtCurrentDateClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    CurrencyConversionActivity.this,
                    new MyOnDateSetListener(),
                    2022,
                    11,
                    27
            );

            datePickerDialog.show();
        }
    }

    class MyOnDateSetListener implements DatePickerDialog.OnDateSetListener {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            txtCurrentDate.setText(year + "--" + month + "--" + dayOfMonth);
        }
    }

    class txtCurrentTimeClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    CurrencyConversionActivity.this,
                    new MyOnTimeSetListener(),
                    4,
                    8,
                    false
            );

            timePickerDialog.show();
        }
    }

    class MyOnTimeSetListener implements TimePickerDialog.OnTimeSetListener {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            txtCurrentTime.setText(hourOfDay + ":" + minute);
        }
    }

    class BtnConvertClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            ConversionDialog conversionDialog = new ConversionDialog(CurrencyConversionActivity.this);
            conversionDialog.show();
        }
    }
}