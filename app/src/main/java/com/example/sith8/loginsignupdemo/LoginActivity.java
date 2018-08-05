package com.example.sith8.loginsignupdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.sith8.loginsignupdemo.DatabaseHelper.USERNAME;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login=findViewById(R.id.loginFormButton);
        final TextView tv1,tv2;
        tv1=findViewById(R.id.username_LoginForm);
        tv2=findViewById(R.id.password_LoginForm);
        final Context context;
        context=this;

        /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3= new Intent(context,HomeActivity.class);
                startActivity(intent3);
            }
        });*/
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db= new DatabaseHelper(context);
                String userName=tv1.getText().toString();
                String passWord=tv2.getText().toString();
                String name=db.validate(userName,passWord);
                if(name==null){
                    Toast.makeText(context,"Invalid User",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent3= new Intent(context,HomeActivity.class);
                    startActivity(intent3);
                }
            }
        });
    }
}