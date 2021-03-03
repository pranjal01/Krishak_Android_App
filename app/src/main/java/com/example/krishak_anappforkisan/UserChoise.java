package com.example.krishak_anappforkisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserChoise extends AppCompatActivity {
    public void farmerLogin(View view) {

        Intent intent = new Intent(this, FarmerHome.class);
        startActivity(intent);
    }
    public void marchentLogin(View view) {

        Intent intent = new Intent(this, MerchentHome.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choise);
    }
}