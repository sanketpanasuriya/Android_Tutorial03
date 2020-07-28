package com.example.tutorial03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicBoolean;


public class MainActivity extends AppCompatActivity {
    private Button button;

    final EditText Email=(EditText)findViewById(R.id.edtEmail);
    final EditText Password=(EditText)findViewById(R.id.edtPassword);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button)findViewById(R.id.btnLogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                    startActivity(intent);
            }
        });
    }
    void checkDataEntered(){
        if(isEmpty(Email)) {
            Toast t = Toast.makeText(this,"You must enter Username",Toast.LENGTH_SHORT);
            t.show();
        }
    }
    public boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

}