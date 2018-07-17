package com.flamezz.creditmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewUserActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private ListView listView;
    private Profile profile;
    private List<String> detailList;

    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_user_view);
        InitializeControls();
    }

    private void InitializeControls()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("Profile");
        listView = findViewById(R.id.listview);
        detailList = new ArrayList<>();
        retrieveUsers();
    }

    private void retrieveUsers()
    {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot details:dataSnapshot.getChildren())
                {
                        profile = details.getValue(Profile.class);
                        detailList.add(profile.name);

                }
                CustomAdapter customAdapter = new CustomAdapter(detailList);
                listView.setAdapter(customAdapter);

                selectUsers();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void selectUsers()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                databaseReference.getDatabase().getReference();
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            for(DataSnapshot ds: dataSnapshot.getChildren()) {

                                String name = ds.child("name").getValue(String.class);
                                String email = ds.child("email").getValue(String.class);
                                String phone = ds.child("phone").getValue(String.class);
                                String currentcredit = ds.child("currentcredit").getValue(String.class);
                                Intent intent = new Intent(ViewUserActivity.this, SelectUserActivity.class);
                                intent.putExtra("PROF_NAME", name);
                                intent.putExtra("PROF_EMAIL", email);
                                intent.putExtra("PROF_PHONE", phone);
                                intent.putExtra("PROF_CREDIT", currentcredit);

                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


            }
        });
    }

}
