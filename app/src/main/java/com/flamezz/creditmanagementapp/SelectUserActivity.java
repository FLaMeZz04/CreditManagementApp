package com.flamezz.creditmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SelectUserActivity extends AppCompatActivity{
        private TextView retrieveName,retreiveEmail,retrieveNumber,retrieveCredit;
        private Button transferCredit;
        private Profile profile;
        private DatabaseReference databaseReference;
        String getname,getemail,getphone,getcredit;
        protected void onCreate(Bundle savedInstance)
        {
            super.onCreate(savedInstance);
            setContentView(R.layout.activity_select_user);
            InitializeControls();

        }

        private void InitializeControls()
        {
            databaseReference = FirebaseDatabase.getInstance().getReference("Profile");
            retrieveName = findViewById(R.id.retriveName);
            retreiveEmail = findViewById(R.id.retriveEmail);
            retrieveNumber = findViewById(R.id.retriveNumber);
            retrieveCredit = findViewById(R.id.retriveCredit);
            transferCredit = findViewById(R.id.transferCredit);
            setDetails();
            setUpTransferCredit();
        }
        private void setDetails()
        {
            Intent intent = getIntent();
            getname = intent.getStringExtra("PROF_NAME");
            getemail = intent.getStringExtra("PROF_EMAIL");
            getphone = intent.getStringExtra("PROF_PHONE");
            getcredit = intent.getStringExtra("PROF_CREDIT");
                        retrieveName.setText(getname);
                        retreiveEmail.setText(getemail);
                        retrieveNumber.setText(getphone);
                        retrieveCredit.setText(getcredit);

        }


    public void OnClick(View view) {
       onBackPressed();
    }

    private void setUpTransferCredit()
    {
        transferCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(SelectUserActivity.this,TransferCreditActivity.class);
               startActivity(intent);

            }
        });
    }
}
