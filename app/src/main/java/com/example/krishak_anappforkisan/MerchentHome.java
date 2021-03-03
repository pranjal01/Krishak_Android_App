package com.example.krishak_anappforkisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MerchentHome extends AppCompatActivity {
    public void merchentBuyHome(View view){
        Intent intent = new Intent(this, MerchantBuyHome.class);
        startActivity(intent);
    }
    public void merchentSell(View view){
        Intent intent = new Intent(this, MerchentSell.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchent_home);
    }
}