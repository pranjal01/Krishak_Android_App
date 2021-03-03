package com.example.krishak_anappforkisan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.krishak_anappforkisan.util.ItemRow;
import com.example.krishak_anappforkisan.util.RecyclerViewAdapter;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FarmerSell extends AppCompatActivity {
    private DatabaseReference mDatabase;

    RecyclerView recyclerView;
    RecyclerViewAdapter mAdapter;

    List<ItemRow> itemList;
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
        setContentView(R.layout.activity_farmer_sell);
        EditText item, type, remark, price, qty, c_no;
        Button setPrice;
        item = findViewById(R.id.item);
        type = findViewById(R.id.type);
        remark = findViewById(R.id.remark);
        price = findViewById(R.id.editTextNumber);
        qty = findViewById(R.id.editTextNumber2);
        c_no = findViewById(R.id.editTextPhone2);
        Date currentTime = Calendar.getInstance().getTime();
        setPrice = findViewById(R.id.button2);
        setPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item1 = item.getText().toString();
                String type1 = type.getText().toString();
                String remark1 = remark.getText().toString();
                String price1 = price.getText().toString();
                String qty1 = qty.getText().toString();
                String c_no1 = c_no.getText().toString();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("at-your-price");
                myRef.child(currentTime.toString()).child("crop name").setValue(item1);
                myRef.child(currentTime.toString()).child("type").setValue(type1);
                myRef.child(currentTime.toString()).child("selller name").setValue(remark1);
                myRef.child(currentTime.toString()).child("price").setValue(price1);
                myRef.child(currentTime.toString()).child("qty").setValue(qty1);
                myRef.child(currentTime.toString()).child("c_no").setValue(c_no1);

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
                        Toast.makeText(FarmerSell.this, "error", Toast.LENGTH_LONG).show();

                        Log.w("Error", "Failed to read value.", error.toException());
                    }
                });

            }
        });

    }
}