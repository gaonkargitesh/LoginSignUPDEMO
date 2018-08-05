package com.example.sith8.loginsignupdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    TextView tv;
    Button signupform;
    Context context;

    private EditText fullname;
    private EditText email;
    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        context=this;

        signupform=findViewById(R.id.signUpFormButton);
        fullname=findViewById(R.id.fullname_EditText);
        email=findViewById(R.id.email_EditText);
        username=findViewById(R.id.username_EditText);
        password=findViewById(R.id.password_EditText);
        confirmPassword=findViewById(R.id.confirmpassword_EditText);


        signupform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Fullname=fullname.getText().toString();
                String Email=email.getText().toString();
                String Username=username.getText().toString();
                String Password=password.getText().toString();
                String ConfirmPassword=confirmPassword.getText().toString();

                if(Fullname.isEmpty()){
                    Toast.makeText(context,"FullName is empty",Toast.LENGTH_SHORT).show();
                }
                else if(Email.isEmpty()){
                    Toast.makeText(context,"Email is empty",Toast.LENGTH_SHORT).show();
                }
                else if(Username.isEmpty()){
                    Toast.makeText(context,"Username is empty",Toast.LENGTH_SHORT).show();
                }
                else if(Password.isEmpty()){
                    Toast.makeText(context,"Password is empty",Toast.LENGTH_SHORT).show();
                }
                else if(ConfirmPassword.isEmpty()){
                    Toast.makeText(context,"Confirm Password is empty",Toast.LENGTH_SHORT).show();
                }
                else if(!Password.equals(ConfirmPassword)){
                    Toast.makeText(context, "Password is not same", Toast.LENGTH_SHORT).show();
                }
                else{
                    DatabaseHelper databaseHelper = new DatabaseHelper(context);
                    UserModel model = new UserModel();
                    model.setFull_name(fullname.getText().toString());
                    model.setEmail(email.getText().toString());
                    model.setUser_name(username.getText().toString());
                    model.setPassword(password.getText().toString());
                    databaseHelper.insert_user(model);
                    Intent intent =new Intent(context,HomeActivity.class);
                    startActivity(intent);
                }


            }
        });
    }
}
