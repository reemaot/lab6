package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText people = (EditText) findViewById(R.id.editTextNumber3);
        final EditText license = (EditText) findViewById(R.id.editTextNumber);
        final EditText days = (EditText) findViewById(R.id.editTextNumber2);
        final Button button = (Button) findViewById(R.id.button);

        final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int licenseVal= Integer.parseInt(license.getText().toString());
                if (licenseVal < 1) {
                    Toast.makeText(MainActivity.this, "Your Driving License will expire soon.   "
                            +"Please renew it first then visit us back :)", Toast.LENGTH_LONG).show(); return;
                }
                    int peopleVal = Integer.parseInt(people.getText().toString());
                    int daysVal = Integer.parseInt(days.getText().toString());
                    SharedPreferences.Editor editor= sp.edit();
                    editor.putInt("people1",peopleVal);
                    editor.putInt("days1", daysVal);
                    editor.commit();

                    startActivity(new Intent(MainActivity.this, MainActivity2.class));

            }
        });
    }
}