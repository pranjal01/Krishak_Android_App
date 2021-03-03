package com.example.krishak_anappforkisan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;

public class MerchantBuyMprice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_buy_mprice);
        EditText cropname, type, buyer,price, shop, address,c_no;
        Button setPrice;
        cropname = findViewById(R.id.Fertilizername);
        type = findViewById(R.id.usedon);
        buyer = findViewById(R.id.seller);
        price = findViewById(R.id.price);
        shop = findViewById(R.id.shop);
        address= findViewById(R.id.address);
        c_no = findViewById(R.id.number);
        Date currentTime = Calendar.getInstance().getTime();
        setPrice = findViewById(R.id.button18);
        setPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fertilizername1 = cropname.getText().toString();
                String usedon1 = type.getText().toString();
                String seller1 = buyer.getText().toString();
                String price1 = price.getText().toString();
                String shop1 = shop.getText().toString();
                String address1 = address.getText().toString();
                String c_no1 = c_no.getText().toString();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("at-merchant-price");
                myRef.child(currentTime.toString()).child("crop name").setValue(fertilizername1);
                myRef.child(currentTime.toString()).child("type").setValue(usedon1);
                myRef.child(currentTime.toString()).child("buyer name").setValue(seller1);
                myRef.child(currentTime.toString()).child("price").setValue(price1);
                myRef.child(currentTime.toString()).child("shop").setValue(shop1);
                myRef.child(currentTime.toString()).child("c_no").setValue(c_no1);
                myRef.child(currentTime.toString()).child("address").setValue(address1);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            for (DataSnapshot ds1 : ds.getChildren()) {
                                Log.e(ds.getKey(), ds1.getKey() +" :"+ ds1.getValue());
//                            ds.child("item").getValue();
//                            ds.child("item").getValue();
//                            ds.child("item").getValue();
//                            ds.child("item").getValue();
//                            ds.child("item").getValue();
                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Toast.makeText(MerchantBuyMprice.this, "error", Toast.LENGTH_LONG).show();

                        Log.w("Error", "Failed to read value.", error.toException());
                    }
                });

            }
        });

    }
}