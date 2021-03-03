package com.example.krishak_anappforkisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FarmerSellHome extends AppCompatActivity {
    public void myprice(View view){
        Intent intent = new Intent(this,  FarmerSell.class);
        startActivity(intent);
    }
    public void listbuyers(View view){
        Intent intent = new Intent(this,  ListBuyers.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_sell_home);
    }
}