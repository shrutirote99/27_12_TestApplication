package com.example.testapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ConversionDialog extends Dialog {
    TextView txtAnswer;
    RadioButton radioUSA,radioAustralia,radioChina,radioUK;

    public ConversionDialog(@NonNull Context context){
        super(context);
        setContentView(R.layout.conversion_dialog);

        initViews();
        initListeners();
    }

    public void initViews(){
        txtAnswer = findViewById(R.id.txtAnswer);
        radioUSA = findViewById(R.id.radioUSA);
        radioAustralia = findViewById(R.id.radioAustralia);
        radioChina = findViewById(R.id.radioChina);
        radioUK = findViewById(R.id.radioUK);
    }

    public void initListeners(){
        radioUSA.setOnClickListener(new RadioUSAClickListener());
        radioAustralia.setOnClickListener(new RadioAustraliaClickListener());
        radioChina.setOnClickListener(new RadioChinaClickListener());
        radioUK.setOnClickListener(new RadioUKClickListener());
    }

    class RadioUSAClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

        }
    }

    class RadioAustraliaClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

        }
    }

    class RadioChinaClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

        }
    }

    class RadioUKClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {

        }
    }
}
