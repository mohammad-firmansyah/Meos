package com.example.jmp1.ui.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.jmp1.R;
import com.example.jmp1.databinding.ActivityDashboardBinding;
import com.example.jmp1.ui.Insert.InsertActivity;
import com.example.jmp1.ui.Longlist.LonglistActivity;

public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(DashboardActivity.this, LonglistActivity.class));
            }
        });

        binding.inputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(DashboardActivity.this, InsertActivity.class));
            }
        });

    }
}