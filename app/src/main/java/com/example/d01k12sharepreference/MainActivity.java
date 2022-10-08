package com.example.d01k12sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvNumber;
    private int count = 0;

    // Share preference
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNumber = findViewById(R.id.tvNumber);
        preferences = this.getPreferences(MODE_PRIVATE);

        // Kiem tra xem co du lieu hay ko?
        count = preferences.getInt("Count",0);
        tvNumber.setText(String.valueOf(count));
    }

    public void increment(View view) {
        count ++ ;
        tvNumber.setText(String.valueOf(count));
    }

    public void decrement(View view) {
        count --;
        tvNumber.setText(String.valueOf(count));
    }

    @Override
    protected void onPause() {
        super.onPause();
        preferences.edit().putInt("Count", count).apply();
    }
}