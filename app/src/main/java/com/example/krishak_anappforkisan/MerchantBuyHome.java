package com.example.krishak_anappforkisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MerchantBuyHome extends AppCompatActivity {
    public void buyAtFarmerPrice(View view){
        Intent intent = new Intent(this, MerchentBuyNew.class);
        startActivity(intent);
    }
    public void buyAtMerchantPrice(View view){
        Intent intent = new Intent(this, MerchantBuyMprice.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_buy_home);
    }
}