package com.example.fillformactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class FormValidationScreen1 extends AppCompatActivity {
    //Initializing variables
    TextInputLayout name,mail,phone,passwd;
    Button submtbtn;
    EditText nameedt,mailedt,phoneedt,pwedt;
    String namestr,mailstr,phonestr,pwstr;
    String emailPattern = "[a-z0-9._-]+@[a-z]+\\.+[a-z]+";
    String regexStr = "^[0-9]$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_validation_screen1);

        //Assign variables
        name=findViewById(R.id.outlinedTextField);
        mail=findViewById(R.id.outlinedTextField1);
        phone=findViewById(R.id.outlinedTextField2);
        passwd=findViewById(R.id.outlinedTextField3);
        submtbtn=findViewById(R.id.btnid);

        nameedt=findViewById(R.id.edt_fullname);
        mailedt=findViewById(R.id.edt_mail);
        phoneedt=findViewById(R.id.edt_phone);
        pwedt=findViewById(R.id.edt_pw);


        submtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Converting Edit Text Value to String
                namestr=nameedt.getText().toString();
                mailstr=mailedt.getText().toString();
                phonestr=phoneedt.getText().toString();
                pwstr=pwedt.getText().toString();

                //make function for validation and pass parameters
                if(validateinfo(namestr,mailstr,phonestr,pwstr)) {
                    Intent intt = new Intent(FormValidationScreen1.this, FormValidationScreen2.class);
                    intt.putExtra("name", namestr);
                    intt.putExtra("mail",mailstr);
                    intt.putExtra("phone",phonestr);
                    intt.putExtra("pw",pwstr);
                    startActivity(intt);
                }
//                if(TextUtils.isEmpty(namestr))
//                {
//                    nameedt.setError("Enter Name");
//                }
//                else  if(TextUtils.isEmpty(mailstr))
//                {
//                    mailedt.setError("Enter Mail");
//                }
//                else if(TextUtils.isEmpty(phonestr))
//                {
//                    phoneedt.setError("Enter Mobile");
//                }
//                else  if(phonestr.length()<10)
//                {
//                  phoneedt.setError("Enter 10 Digit Mobile Number");
//                }
//                else
//                {
//                    Toast.makeText(FormValidationScreen1.this, ""+namestr+"\n"+mailstr+"\n"+phonestr+"\n"+pwstr, Toast.LENGTH_SHORT).show();
//
//                }
//
//
//
            }
        });
    }
    private boolean validateinfo(String namestr,String mailstr,String phonestr,String pwstr)
    {
        if(namestr.length()==0 )
        {
            nameedt.requestFocus();
            nameedt.setError("Field cannot be Empty");
        }
        else if (!namestr.matches("[a-zA-z]+")) {
            nameedt.requestFocus();
            nameedt.setError("Enter only Alphabetic characters");

            return  false;
        }
        else if (mailstr.trim().length()==0)
        {
            mailedt.requestFocus();
            mailedt.setError("Field cannot be Empty");
        }
        else if (phonestr.trim().length()==0)
        {
            phoneedt.requestFocus();
            phoneedt.setError("Field cannot be Empty");
        }
else
        if(phonestr.length() < 10 || phonestr.length()>13 || phonestr.trim().matches(regexStr)==true ) {
            phoneedt.requestFocus();
            phoneedt.setError("Enter valid number");
            return false;
        }


        else if (pwstr.length()==0)
        {
            pwedt.requestFocus();
            pwedt.setError("Field cannot be Empty");
        }
//        else  if (pwstr.length() < 8)
//        {
//            pwedt.requestFocus();
//            pwedt.setError("please enter minimum 8 Characters");
//        }
        else if (!pwstr.trim().matches( "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*+=?-]).{8,15}$")) {
            //not having special characters error message
            pwedt.requestFocus();
            pwedt.setError("please enter minimum 1 special Character");
            return  false;
        }
        else if (!mailstr.trim().matches(emailPattern)) {
            mailedt.requestFocus();
            mailedt.setError("invalid email address");
        }
        return true;
    }
//    private boolean isValidEmailId(String email){
//
//        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
//                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
//                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
//                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
//                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1,}|"
//                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
//    }



/*    public void dispbtn(View view) {
        namestr=submtbtn.getText().toString();
      //  startActivity(new Intent(FormValidationScreen1.this,FormValidationScreen2.class));
        *//*Intent ittt=new Intent(FormValidationScreen1.this,FormValidationScreen2.class);
        ittt.putExtra("hello",namestr);
        startActivity(ittt);*//*
    }*/
}