package com.example.finalui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChagePawwordActivity extends AppCompatActivity {
private EditText pernumber,perpassw,perconfirmpass;
private Button confbutt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chage_pawword);
        pernumber=findViewById(R.id.phonenochage);
        perpassw=findViewById(R.id.passwordchange);
        perconfirmpass=findViewById(R.id.confirmpasswordchange);
        confbutt=findViewById(R.id.changedbutt);
        confbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckEmpty();
                confirmPassword();
            }
        });
    }

    private void confirmPassword() {
        if(!perpassw.getText().toString().trim().equals(perconfirmpass.getText().toString().trim())){

        }else
        {
            //Do What We Have to Do
        }
    }

    private void CheckEmpty() {
        if(TextUtils.isEmpty(pernumber.getText().toString().trim())){
            pernumber.setError("Field can't be empty");
        }
        if(TextUtils.isEmpty(perpassw.getText().toString().trim())){
            perpassw.setError("Field can't be empty");
        }
        if(TextUtils.isEmpty(perconfirmpass.getText().toString().trim()))
        perconfirmpass.setError("Field can't be empty");
    }
}