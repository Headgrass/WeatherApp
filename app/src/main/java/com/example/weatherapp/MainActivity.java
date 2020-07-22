package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends BaseActivity {
    private static final Integer REQ_CODE = 88;
    private static final Integer CITY_CODE = 36;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_set);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Settings.class);
                startActivityForResult(intent, REQ_CODE);
            }
        });

        }

        private void initHttp() throws IOException {
            HttpURLConnection urlConnection = null;

            URL url = new URL("http://google.ru");
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(1000);
        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView tvCity = findViewById(R.id.current_City);
        if (requestCode == REQ_CODE){
            recreate();
        }
//        if (requestCode == CITY_CODE){
//            tvCity.setText();
//        }
    }

}
