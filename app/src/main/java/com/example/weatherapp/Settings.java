package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class Settings extends AppCompatActivity {
private RecyclerView cityList;
private CityAdapter cityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        cityList = findViewById(R.id.rvChangeCity);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        cityList.setLayoutManager(layoutManager);

        cityList.setHasFixedSize(true);
        cityAdapter = new CityAdapter();
        cityList.setAdapter(cityAdapter);
    }

    public void onClick(View v) {
        TextInputEditText textinput = findViewById(R.id.inputCity);
        Intent intentResult = new Intent();
        intentResult.putExtra("Number", textinput.getText().toString());
        setResult(RESULT_OK, intentResult);
        finish();
    }
}
