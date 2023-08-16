package com.example.jmp1.ui.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.example.jmp1.R;
import com.example.jmp1.databinding.ActivityDetailMhsBinding;
import com.example.jmp1.ui.Dashboard.DashboardActivity;
import com.example.jmp1.ui.Longlist.LonglistActivity;
import com.example.jmp1.utils.DatabaseHelper;

public class DetailMhsActivity extends AppCompatActivity {

    private ActivityDetailMhsBinding binding;

    private DatabaseHelper databaseHelper;
    String id_content = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailMhsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String nama = "";
        if (intent != null) {
            nama = intent.getStringExtra("KEY_STRING");
        }


        databaseHelper = new DatabaseHelper(this);
        Cursor cursor = databaseHelper.getDataByName(nama);

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getColumnIndex("id");
            int nomor = cursor.getColumnIndex("nomor");
            int nama2 = cursor.getColumnIndex("nama");
            int tgl_lahir = cursor.getColumnIndex("tgl_lahir");
            int gender = cursor.getColumnIndex("gender");
            int alamat = cursor.getColumnIndex("alamat");
            if (id >= 0) {
                id_content = cursor.getString(id);
                String nomor_content = cursor.getString(nomor);
                String nama2_content = cursor.getString(nama2);
                String tgl_content = cursor.getString(tgl_lahir);
                String gender_content = cursor.getString(gender);
                String alamat_content = cursor.getString(alamat);

                binding.alamat.setText(alamat_content);
                binding.nomor.setText(nomor_content);
                binding.nama.setText(nama2_content);
                binding.tglLahir.setText(tgl_content);
                binding.gender.setText(gender_content);
            } else {
            }
        } else {
        }

        binding.input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.updateData(id_content,binding.nomor.getText().toString(),binding.nama.getText().toString(),binding.tglLahir.getText().toString(),binding.gender.getText().toString(),binding.alamat.getText().toString());
                finish();
                startActivity(new Intent(DetailMhsActivity.this,DashboardActivity.class));
            }
        });

        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteData(id_content);
                finish();
                startActivity(new Intent(DetailMhsActivity.this,DashboardActivity.class));
            }
        });
    }

}