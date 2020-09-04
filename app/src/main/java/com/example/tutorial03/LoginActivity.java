package com.example.tutorial03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button button;
    EditText Email;
    EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email=(EditText)findViewById(R.id.edtEmail);
        Password=(EditText)findViewById(R.id.edtPassword);

        button = (Button)findViewById(R.id.btnLogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                checkDataEntered();
            }
        });
    }
    void checkDataEntered(){

        if(isEmpty(Email)) {
            Toast t = Toast.makeText(this,"You must enter Username",Toast.LENGTH_SHORT);
            t.show();
        }
        else if(isEmpty(Password)) {
            Toast t = Toast.makeText(this,"You must enter Password",Toast.LENGTH_SHORT);
            t.show();
        } else if(!isEmail(Email)){
            Email.setError("Enter valid email");
            Toast t = Toast.makeText(this,"Enter valid Email address",Toast.LENGTH_SHORT);
            t.show();
        } else if(!Email.getText().toString().equals("admin@gmail.com")){
            Email.setError("Enter valid username");
            Toast t = Toast.makeText(this,"Enter valid username",Toast.LENGTH_SHORT);
            t.show();
        } else if(!Password.getText().toString().equals("admin")){
            Password.setError("Enter valid password");
            Toast t = Toast.makeText(this,"Enter valid password",Toast.LENGTH_SHORT);
            t.show();
        }else{
            Intent intent = new Intent(LoginActivity.this, WecomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
    public boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    public boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}