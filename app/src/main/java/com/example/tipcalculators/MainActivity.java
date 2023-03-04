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

    private EditText cost_of_service;
    private Button calculate_button;
    private RadioGroup radioGroup;
    private Switch round_up_switch;
    private TextView tip_result;
    private double tip_amount;
    private double tip_percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cost_of_service= findViewById(R.id.cost_of_service);
        calculate_button=findViewById(R.id.calculate_button);
        radioGroup=findViewById(R.id.radioGroup);
        round_up_switch=findViewById(R.id.round_up_switch);
        tip_result=findViewById(R.id.tip_result);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cost = cost_of_service.getText().toString();
                double costAmount = Double.parseDouble(cost);
                double checkedRadioButton= radioGroup.getCheckedRadioButtonId();
                if(checkedRadioButton==R.id.option_twenty_percent){
                    tip_percent=0.2;
                } else if (checkedRadioButton==R.id.option_eighteen_percent) {
                    tip_percent=0.18;
                }else if (checkedRadioButton==R.id.option_fifteen_percent) {
                    tip_percent=0.15;
                }else {
                    tip_percent=0.0;
                }
                tip_amount=costAmount*tip_percent;
                if (round_up_switch.isChecked()){
                    tip_amount=Math.round(tip_amount);
                }
                tip_result.setText(" "+tip_amount);
            }

        });
    }
}