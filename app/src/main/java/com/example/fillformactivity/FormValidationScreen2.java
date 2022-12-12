package com.example.fillformactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FormValidationScreen2 extends AppCompatActivity {
            TextView txtvw1,txtvw2,txtvw3,txtvw4;
            String txtvwstr1,txtvwstr2,txtvwstr3,txtvwstr4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_validation_screen2);
        txtvw1=findViewById(R.id.nametextvw);
        txtvw2=findViewById(R.id.mailtextvw);
        txtvw3=findViewById(R.id.phonetextvw);
        txtvw4=findViewById(R.id.pwordtextvw);

        txtvwstr1=getIntent().getStringExtra("name");
        txtvw1.setText("Fullname :"+txtvwstr1);

        txtvwstr2=getIntent().getStringExtra("mail");
        txtvw2.setText("E-mail :"+txtvwstr2);

        txtvwstr3=getIntent().getStringExtra("phone");
        txtvw3.setText("Phone No :"+txtvwstr3);

        txtvwstr4=getIntent().getStringExtra("pw");
        txtvw4.setText("Password :"+txtvwstr4);
    }
}