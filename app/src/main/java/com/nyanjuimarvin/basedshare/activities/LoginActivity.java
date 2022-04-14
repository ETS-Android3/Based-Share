package com.nyanjuimarvin.basedshare.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nyanjuimarvin.basedshare.databinding.ActivityLoginBinding;
import com.nyanjuimarvin.basedshare.firebase.authentication.Authentication;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding loginBinding;
    private FirebaseAuth.AuthStateListener listener;
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = loginBinding.getRoot();
        setContentView(view);

        loginBinding.forgotPasswordText.setOnClickListener(view1 -> {
            forgotPassword();
        });

        loginBinding.signButton.setOnClickListener(view1 -> {
            signIn();
        });
        createAuthStateListener();
    }

    private void forgotPassword(){
        auth = Authentication.getAuth();
        String emailAddress = loginBinding.signEmail.getText().toString().trim();

        if(emailAddress.equals("")){
            loginBinding.signEmail.setError("Enter email before clicking forgot password");
            Toast.makeText(getApplicationContext(),"Provide a registered email",Toast.LENGTH_LONG).show();
            return;
        }

        if(!emailAddress.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
            loginBinding.signEmail.setError("Please use a valid email format");
            Toast.makeText(getApplicationContext(),"Invalid Email Format", Toast.LENGTH_LONG).show();
            return;
        }

        auth.sendPasswordResetEmail(emailAddress).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Log.i("success","Email Sent");
                Toast.makeText(getApplicationContext(),"Email was sent.Check your inbox",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),String.format("Sorry, no account with %s was found",emailAddress),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void signIn(){
        auth = Authentication.getAuth();
        String emailAddress = loginBinding.signEmail.getText().toString().trim();
        String password = loginBinding.signPassword.getText().toString().trim();

        if(emailAddress.equals("")){
            loginBinding.signEmail.setError("Please enter an Email Address");
            return;
        }
        if(!emailAddress.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
            loginBinding.signEmail.setError("Please Enter a Valid Email");
            return;
        }
        if(password.equals("") || password.length() < 6){
            loginBinding.signPassword.setError("Password must contain 6 characters or more");
            return;
        }

        auth.signInWithEmailAndPassword(emailAddress, password).addOnCompleteListener(task -> {
            if (task.isComplete()){
                Log.d("Success","Login via Email Successful");
                Toast.makeText(getApplicationContext(),"Authentication Successful", Toast.LENGTH_LONG).show();
            }else{
                Log.w("failed","Sign In With Email Failed", task.getException());
                Toast.makeText(getApplicationContext(),"Authentication Failed",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void createAuthStateListener(){
        listener = firebaseAuth -> {
            user = Authentication.getAuth().getCurrentUser();
            if (user != null){
                Intent intent = new Intent(LoginActivity.this, GameActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        auth = Authentication.getAuth();
        auth.addAuthStateListener(listener);
    }

    @Override
    public void onStop() {
        super.onStop();
        auth = Authentication.getAuth();
        auth.removeAuthStateListener(listener);
    }
}