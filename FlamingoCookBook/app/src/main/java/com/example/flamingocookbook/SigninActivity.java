package com.example.flamingocookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {
    EditText signup_fullname, signup_lastname, signup_email, signup_password, signup_confirm_password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        signup_fullname = findViewById(R.id.signup_fullname_id);
        signup_lastname = findViewById(R.id.signup_lastname_id);
        signup_email = findViewById(R.id.sigup_email_id);
        signup_password = findViewById(R.id.signup_password_id);
        signup_confirm_password = findViewById(R.id.signup_confirm_password_id);

    }

    public void Signin(View view) {
        //retrive the value from register form
        String fullname = signup_fullname.getText().toString();
        String lastname = signup_lastname.getText().toString();
        String email = signup_email.getText().toString().trim();
        String password = signup_password.getText().toString().trim();
        String confirm_password = signup_confirm_password.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Email is Empty", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(confirm_password)){
            Toast.makeText(this, "Confirm Password field is Empty", Toast.LENGTH_SHORT).show();
        }

        if (password.length() <10){
            Toast.makeText(this, "Password not strong enough", Toast.LENGTH_SHORT).show();

        }

        if(password.equals(confirm_password)){
            createAccount(email, password);
        }
        else{
            Toast.makeText(this, "Password do not match", Toast.LENGTH_SHORT).show();
        }


    }

    private void createAccount(String email, String password) {
        //firebase signup code
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SigninActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SigninActivity.this, MainActivity.class));
                        } else {
                            Toast.makeText(SigninActivity.this, "User Register failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}
