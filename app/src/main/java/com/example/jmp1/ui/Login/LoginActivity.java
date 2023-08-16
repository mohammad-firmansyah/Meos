package com.example.jmp1.ui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.example.jmp1.R;
import com.example.jmp1.databinding.ActivityDashboardBinding;
import com.example.jmp1.databinding.ActivityLoginBinding;
import com.example.jmp1.ui.Dashboard.DashboardActivity;
import com.example.jmp1.ui.Longlist.LonglistActivity;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String email = sharedPreferences.getString("email", null);
        String pass = sharedPreferences.getString("password", null);

        if (email != null && pass != null) {
            finish();
            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
        }

            binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.email.getText().toString().equals("admin") && binding.pass.getText().toString().equals("admin")) {
                    editor.putString("email", binding.email.getText().toString());
                    editor.putString("password", binding.pass.getText().toString());
                    editor.apply();

                    finish();
                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                } else {

                    Toast.makeText(LoginActivity.this, "Password dan Email salah", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }
}