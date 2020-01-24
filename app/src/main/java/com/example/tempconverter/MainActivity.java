package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.text.DisplayContext.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private EditText FahBox;
    private TextView CelBox;
    private RadioButton FtoCRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FahBox = findViewById(R.id.FahBox);
        CelBox = findViewById(R.id.CelBox);
        FtoCRadio = findViewById(R.id.FtoCradio);
    }

    public void convert(View v) {
        if (FtoCRadio.isChecked()) {
            String input = FahBox.getText().toString();
            if (input.length() > 0) {
                double FahValue = Double.parseDouble(input);
                double CelValue = (FahValue - 32) * 5.0 / 9.0;
                CelBox.setText(String.format("%.1f", CelValue));
            } else {
                Toast.makeText(this, "No Fahrenheit value entered!", Toast.LENGTH_SHORT).show();
            }
        } else {
            String input = CelBox.getText().toString();
            if (input.length() > 0) {
                double CelValue = Double.parseDouble(input);
                double FahValue = 32 + ((CelValue) * (9.0 / 5.0));
                FahBox.setText(String.format("%.1f", FahValue));
            } else {
                Toast.makeText(this, "No Celsius value entered!", Toast.LENGTH_SHORT).show();
            }


        }
    }

}