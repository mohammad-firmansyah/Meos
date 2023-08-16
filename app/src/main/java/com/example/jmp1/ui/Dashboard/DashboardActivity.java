package com.example.jmp1.ui.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.example.jmp1.R;
import com.example.jmp1.databinding.ActivityDashboardBinding;
import com.example.jmp1.ui.Information.InformationActivity;
import com.example.jmp1.ui.Insert.InsertActivity;
import com.example.jmp1.ui.Login.LoginActivity;
import com.example.jmp1.ui.Longlist.LonglistActivity;

public class DashboardActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        binding.showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, LonglistActivity.class));
            }
        });

         binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().clear().apply();
                startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
            }
        });

        binding.inputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, InsertActivity.class));
            }
        });

        binding.information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, InformationActivity.class));
            }
        });

    }
}