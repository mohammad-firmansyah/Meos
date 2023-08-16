package com.example.jmp1.ui.Longlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.jmp1.R;
import com.example.jmp1.adapter.LonglistAdapter;
import com.example.jmp1.utils.DatabaseHelper;

import java.util.ArrayList;

public class LonglistActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_data);

        databaseHelper = new DatabaseHelper(this);

        ArrayList<String> list = databaseHelper.getAllStudentsList();
        RecyclerView rvMhs = findViewById(R.id.rvMhs);
        rvMhs.setLayoutManager(new LinearLayoutManager(this));
        LonglistAdapter adapter = new LonglistAdapter(list,getApplication());
        rvMhs.setAdapter(adapter);
    }
}