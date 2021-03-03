package com.example.krishak_anappforkisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FarmerBuy extends AppCompatActivity {
    public void seed(View view) {
        Intent intent = new Intent(this, BuySeeds.class);
        startActivity(intent);
    }

    public void tools(View view) {
        Intent intent = new Intent(this, BuyTools.class);
        startActivity(intent);
    }

    public void insecticiddes(View view) {
        Intent intent = new Intent(this, BuyInsectisides.class);
        startActivity(intent);
    }

    public void fertilizer(View view) {
        Intent intent = new Intent(this, BuyFertilizer.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_buy);

    }
}