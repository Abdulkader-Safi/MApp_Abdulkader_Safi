package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etFirstName, etLastName, etAge;
    TextView tvViewSubmit;
    Button btnSubmit;
    int yearNow, yearOfBerth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etAge = findViewById(R.id.etAge);

        btnSubmit = findViewById(R.id.btnSubmit);

        tvViewSubmit = findViewById(R.id.tvViewSubmit);

        yearNow = Calendar.getInstance().get(Calendar.YEAR);

        btnSubmit.setOnClickListener(v -> {
            String firstName = etFirstName.getText().toString();
            String lastName = etLastName.getText().toString();
            String age = etAge.getText().toString();

            if(firstName.isEmpty()) {
                etFirstName.setError("Enter Your First Name!!");
                return;
            }

            if(lastName.isEmpty()) {
                etLastName.setError("Enter Your Last Name!!");
                return;
            }

            if(age.isEmpty()) {
                etAge.setError("Enter Your Age!!");
                return;
            }

            yearOfBerth = yearNow - Integer.parseInt(age);

            tvViewSubmit.setVisibility(View.VISIBLE);
            tvViewSubmit.setText("Your full name is: " + firstName + " " + lastName + "\nYou ware born in " + yearOfBerth);
        });

    }
}