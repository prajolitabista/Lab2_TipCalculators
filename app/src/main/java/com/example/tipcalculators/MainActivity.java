package com.example.tipcalculators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText value_to_convert;
    private RadioGroup radioGroup;
    private Switch reverse_switch;
    private Button calculate_button;
    private TextView conversion_result;
    private double conversion;
    private double conversion_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value_to_convert= findViewById(R.id.value_to_convert);
        radioGroup=findViewById(R.id.radioGroup);
        calculate_button= findViewById(R.id.calculate_button);
        conversion_result=findViewById(R.id.conversion_result);
        reverse_switch=findViewById(R.id.reverse_switch);

        calculate_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String value= value_to_convert.getText().toString();
                double valueAmount= Double.parseDouble(value);
                double checkedRadioButton= radioGroup.getCheckedRadioButtonId();
                if(checkedRadioButton==R.id.milliliters_to_ounces){
                    if (reverse_switch.isChecked()) {
                        conversion = 29.6;
                    }
                    else {
                        conversion = 0.03381402;
                    }
                }
                else if (checkedRadioButton==R.id.grams_to_cups) {
                    if (reverse_switch.isChecked()) {
                        conversion = 240;
                    }
                    else {
                        conversion = 0.008;
                    }
                }

                conversion_amount=valueAmount*conversion;
                conversion_result.setText(" "+conversion_amount);
            }
        });
    }
}