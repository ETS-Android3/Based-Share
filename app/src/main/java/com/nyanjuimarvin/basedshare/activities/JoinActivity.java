package com.nyanjuimarvin.basedshare.activities;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.nyanjuimarvin.basedshare.R;
import com.nyanjuimarvin.basedshare.databinding.ActivityJoinBinding;
import com.nyanjuimarvin.basedshare.firebase.authentication.Authentication;

import java.util.Objects;

public class JoinActivity extends AppCompatActivity {

    private ActivityJoinBinding joinBinding;
    private FirebaseAuth newUserAuth;
    private FirebaseUser newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        joinBinding = ActivityJoinBinding.inflate(getLayoutInflater());
        View view = joinBinding.getRoot();
        setContentView(view);

        joinBinding.registerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }

    private boolean isValidEmail(String Email){

        boolean validEmail = (Email != null && Email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"));
        if(!validEmail){
            joinBinding.userEmail.getText().clear();
            joinBinding.userEmail.setError("Please enter a valid Email");
            return false;
        }
        return true;
    }

    private boolean isValidName(String name){
        if(name.equals("")){
            joinBinding.userName.getText().clear();
            joinBinding.userName.setError("Kindly enter your name ");
            return false;
        }
        return true;
    }

    private boolean isPasswordValid(String password,String confirmPassword ){
        if(password.length() < 6){
            joinBinding.userPassword.getText().clear();
            Toast.makeText(getApplicationContext(),"Password too short",Toast.LENGTH_LONG).show();
            joinBinding.userPassword.setError("Passwords must have 6 characters or more");
            return false;
        }else if(!password.equals(confirmPassword)){
            joinBinding.confirmPassword.getText().clear();
            Toast.makeText(getApplicationContext(),"Passwords do not match",Toast.LENGTH_LONG).show();
            joinBinding.confirmPassword.setError("Passwords do not match");
            return false;
        }
        return true;
    }

    private boolean validInput(String name, String email,String password,String confirmPassword){
        return name.matches("([a-zA-z]+|[a-zA-Z]+\\s[a-zA-Z]+)*")
                && email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
                && password.equals(confirmPassword);
    }

    private void createUser(){
        String userName = joinBinding.userName.getText().toString().trim();
        String userEmail = joinBinding.userEmail.getText().toString().trim();
        String userPassword = joinBinding.userPassword.getText().toString().trim();
        String confirmPassword = joinBinding.confirmPassword.getText().toString().trim();

        boolean validEmail = isValidEmail(userEmail);
        boolean validName = isValidName(userName);
        boolean validPassword = isPasswordValid(userPassword,confirmPassword);

        newUserAuth = Authentication.getAuth();

        if(!validEmail || !validName || !validPassword){
            Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
            return;
        }

        newUserAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()){
                        createFirebaseUser(Objects.requireNonNull(task.getResult().getUser()));
                        Log.d("Message","Account creation Successful");
                    }else{
                        Log.w("Warning","Account Creation Failed", task.getException());
                        Toast.makeText(getApplicationContext(),"Account Creation Failed",Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void createFirebaseUser(FirebaseUser user){

        String userName = joinBinding.userName.getText().toString().trim();
        newUser = newUserAuth.getCurrentUser();

        UserProfileChangeRequest addName = new UserProfileChangeRequest.Builder()
                .setDisplayName(userName)
                .build();

        user.updateProfile(addName).addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                Log.d(TAG, Objects.requireNonNull(user.getDisplayName()));
                Toast.makeText(getApplicationContext(),"Name set in firebase",Toast.LENGTH_SHORT).show();
            }
        });
        }
}