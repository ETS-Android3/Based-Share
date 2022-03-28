package com.nyanjuimarvin.basedshare.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.ActivityJoinBinding;

public class JoinActivity extends AppCompatActivity {

    private ActivityJoinBinding joinBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        joinBinding = ActivityJoinBinding.inflate(getLayoutInflater());
        View view = joinBinding.getRoot();
        setContentView(view);

        joinBinding.registerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String userName = joinBinding.userName.getText().toString().trim();
                String userEmail = joinBinding.userEmail.getText().toString().trim();
                String userPassword = joinBinding.userPassword.getText().toString().trim();
                String confirmPassword = joinBinding.confirmPassword.getText().toString().trim();

                if (userName.isEmpty()) {
                    System.out.println(userName);
                    joinBinding.userName.setError("Name is Required");
                    Toast.makeText(getApplicationContext(),"Name required",Toast.LENGTH_LONG).show();
                } else if (userEmail.isEmpty()) {
                    joinBinding.userEmail.setError("E-mail is required");
                    Toast.makeText(getApplicationContext(),"Email Required",Toast.LENGTH_LONG).show();
                } else if (userPassword.isEmpty()) {
                    joinBinding.userPassword.setError("Password Required");
                    Toast.makeText(getApplicationContext(),"Password Required",Toast.LENGTH_LONG).show();
                } else if (confirmPassword.isEmpty()) {
                    joinBinding.confirmPassword.setError("Confirm Password required");
                    Toast.makeText(getApplicationContext(),"Confirm Password",Toast.LENGTH_LONG).show();
                } else if(!(userName.matches("([a-zA-z]+|[a-zA-Z]+\\s[a-zA-Z]+)*"))){
                    joinBinding.userName.getText().clear();
                    joinBinding.userName.setError("Enter a logical Name");
                    Toast.makeText(getApplicationContext(),"Invalid Name Format",Toast.LENGTH_LONG).show();
                }else if(!(userEmail.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))){
                    joinBinding.userEmail.getText().clear();
                    joinBinding.userEmail.setError("Enter a valid Email Format");
                    Toast.makeText(getApplicationContext(),"Invalid Email Format",Toast.LENGTH_LONG).show();
                }else if(!(userPassword.equals(confirmPassword))){
                    joinBinding.confirmPassword.getText().clear();
                    joinBinding.confirmPassword.setError("Password does not match");
                    Toast.makeText(getApplicationContext(),"Passwords do not match",Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), FeedActivity.class);
                    startActivity(intent);
                    intent.putExtra("userName", userName);

                    Toast.makeText(getApplicationContext(), String.format("Registered as %s", userName), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validInput(String name, String email,String password,String confirmPassword){
        return name.matches("([a-zA-z]+|[a-zA-Z]+\\s[a-zA-Z]+)*")
                && email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
                && password.equals(confirmPassword);
    }

}