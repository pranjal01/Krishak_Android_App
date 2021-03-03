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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListBuyers extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter mAdapter;
    EditText edittext;
    List<ItemRow> itemList;
    Button button19;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buyers);
        recyclerView = findViewById(R.id.recycler_view);
        edittext = findViewById(R.id.SearchCrop);
        button19 = findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = edittext.getText().toString();
                FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                DatabaseReference myRef1 = database1.getReference("at-merchant-price");
                myRef1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ItemRow item;
                        itemList = new ArrayList<>();

                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            for (DataSnapshot ds1 : ds.getChildren()) {
                                if (ds1.getKey().toString().equals("crop name")) {
                                    if (ds1.getValue().toString().equals(search)) {
                                        for (DataSnapshot ds2 : dataSnapshot.getChildren()) {
                                            if (ds2.getKey().equals(ds.getKey()))
                                                for (DataSnapshot ds3 : ds2.getChildren()) {
                                                    Log.e(ds2.getKey(), ds3.getKey() + " :" + ds3.getValue());
                                                    item = new ItemRow(ds2.getValue().toString(), ds3.getValue().toString(), ds3.getValue().toString());
                                                    itemList.add(item);
                                                }

                                        }
                                    }
                                }
                            }
                        }
                        mAdapter = new RecyclerViewAdapter(itemList, ListBuyers.this);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ListBuyers.this);
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Toast.makeText(ListBuyers.this, "error", Toast.LENGTH_LONG).show();

                        Log.w("Error", "Failed to read value.", error.toException());
                    }
                });
            }
        });
    }
}