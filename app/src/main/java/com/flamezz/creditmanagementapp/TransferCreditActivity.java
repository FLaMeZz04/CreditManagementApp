package com.flamezz.creditmanagementapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TransferCreditActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_transfer_credit);
    }


    public void userInfo(View view)
    {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        View mview = getLayoutInflater().inflate(R.layout.alertdialog_userinfo,null);
        TextView userInfoName = mview.findViewById(R.id.userInfoName);
        TextView userInfoCredit = mview.findViewById(R.id.userInfoCredit);
        alertdialog.setTitle("\t\t\t\t\tUser Information");
        alertdialog.setView(mview);
        alertdialog.create();
        alertdialog.show();

    }
}
