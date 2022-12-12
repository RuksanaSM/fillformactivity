package com.example.fillformactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submitbtn;
    EditText nameEdttxt,desgedt,emailedt,phoneedt;
    String namestr,desgstr,mailstr,phonestr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitbtn=findViewById(R.id.buttonid);
        nameEdttxt=findViewById(R.id.name_edttxt);
        desgedt=findViewById(R.id.desg_edttxt);
        emailedt=findViewById(R.id.mail_edttxt);
        phoneedt=findViewById(R.id.phone_edttxt);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namestr=nameEdttxt.getText().toString();
                Toast.makeText(MainActivity.this, "FullName"+namestr, Toast.LENGTH_SHORT).show();
                desgstr=desgedt.getText().toString();
                Toast.makeText(MainActivity.this, "Designation"+desgstr, Toast.LENGTH_SHORT).show();

                mailstr=emailedt.getText().toString();
                Toast.makeText(MainActivity.this, "E-mail"+mailstr, Toast.LENGTH_SHORT).show();

                phonestr=phoneedt.getText().toString();
                Toast.makeText(MainActivity.this, "Mobile Number"+phonestr, Toast.LENGTH_SHORT).show();
            }
        });
    }
}