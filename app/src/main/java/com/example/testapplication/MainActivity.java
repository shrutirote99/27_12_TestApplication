package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUserName,edtPassword,edtPhoneNo;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListener();
    }

    public void initViews(){
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        edtPhoneNo = findViewById(R.id.edtPhoneNo);
        btnLogin = findViewById(R.id.btnLogin);
    }

    public void initListener(){
        btnLogin.setOnClickListener(new BtnLoginClickListener());
    }

    class BtnLoginClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this,CurrencyConversionActivity.class);
            intent.putExtra("user",edtUserName.getText().toString());
            intent.putExtra("phone",edtPhoneNo.getText().toString());
            startActivityForResult(intent,1);
        }
    }

    public void mt(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}