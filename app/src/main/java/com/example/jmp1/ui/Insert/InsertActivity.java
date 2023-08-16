package com.example.jmp1.ui.Insert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jmp1.R;
import com.example.jmp1.databinding.ActivityInsertBinding;
import com.example.jmp1.databinding.ActivityLoginBinding;
import com.example.jmp1.ui.Dashboard.DashboardActivity;
import com.example.jmp1.ui.Login.LoginActivity;
import com.example.jmp1.utils.DatabaseHelper;

public class InsertActivity extends AppCompatActivity {
    private ActivityInsertBinding binding;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);
        binding.input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addNewMhs(binding.nomor.getText().toString(),binding.nama.getText().toString(), binding.tglLahir.getText().toString(), binding.gender.getText().toString(), binding.alamat.getText().toString());
                finish();
                startActivity(new Intent(InsertActivity.this,DashboardActivity.class));
            }

        });
    }
}