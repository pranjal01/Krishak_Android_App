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

public class SellTools extends AppCompatActivity {

    private DatabaseReference mDatabase;

    public static class User {

        public String item;
        public String type;

        public User(String item, String type) {
            // ...
            this.item = item;
            this.type = type;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_tools);
        EditText toolname, usedon, seller, price, shop, address,c_no;
        Button setPrice;
        toolname = findViewById(R.id.Fertilizername);
        usedon = findViewById(R.id.usedon);
        seller = findViewById(R.id.seller);
        price = findViewById(R.id.price);
        shop = findViewById(R.id.shop);
         address= findViewById(R.id.address);
        c_no = findViewById(R.id.number);
        Date currentTime = Calendar.getInstance().getTime();
        setPrice = findViewById(R.id.button18);
        setPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tool1 = toolname.getText().toString();
                String usedon1 = usedon.getText().toString();
                String seller1 = seller.getText().toString();
                String price1 = price.getText().toString();
                String shop1 = shop.getText().toString();
                String address1 = address.getText().toString();
                String c_no1 = c_no.getText().toString();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("sell-tools");
                myRef.child(currentTime.toString()).child("tool name").setValue(tool1);
                myRef.child(currentTime.toString()).child("used on").setValue(usedon1);
                myRef.child(currentTime.toString()).child("seller name").setValue(seller1);
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
                        Toast.makeText(SellTools.this, "error", Toast.LENGTH_LONG).show();

                        Log.w("Error", "Failed to read value.", error.toException());
                    }
                });

            }
        });

    }
}