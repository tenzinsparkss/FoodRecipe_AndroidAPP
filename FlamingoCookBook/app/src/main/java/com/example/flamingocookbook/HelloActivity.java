package com.example.flamingocookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
    }
    public void Signin(View view) {
        startActivity(new Intent(this,SigninActivity.class));

    }

    public void login(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
