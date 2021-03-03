package com.example.krishak_anappforkisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MerchentSell extends AppCompatActivity {
    public void sellSeed (View view){
        Intent intent = new Intent(this, SellSeeds.class);
        startActivity(intent);
    }
    public void sellFertilizer(View view){
        Intent intent = new Intent(this, SellFertilizers.class);
        startActivity(intent);
    }
    public void sellTools(View view){
        Intent intent = new Intent(this, SellTools.class);
        startActivity(intent);
    }
    public void sellInsectisides(View view){
        Intent intent = new Intent(this, SellInsectisides.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchent_sell);
    }
}