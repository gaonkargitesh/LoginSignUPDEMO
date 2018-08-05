package com.example.sith8.loginsignupdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context;
        context=this;
        Button signup=findViewById(R.id.homeSignUPButon);
        Button login=findViewById(R.id.homeLoginButton);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(context,SignUpActivity.class);
                startActivity(intent1);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(context,LoginActivity.class);
                startActivity(intent2);
            }
        });

    }
}