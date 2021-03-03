package com.example.krishak_anappforkisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FarmerHome extends AppCompatActivity {

    public void farmerBuy(View view) {

        Intent intent = new Intent(this,  FarmerBuy.class);
        startActivity(intent);
    }
    public void farmerSell(View view) {

        Intent intent = new Intent(this, FarmerSellHome.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_home);
    }
}