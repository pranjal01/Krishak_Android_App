package com.example.krishak_anappforkisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MarchentLogin extends AppCompatActivity {

        public void signUp(View view) {

            Intent intent = new Intent(this, MerchentBuyNew.class);
            startActivity(intent);
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marchent_login);
    }
}