package com.example.basicofkotlin;

import static com.example.basicofkotlin.FunctionClass.div;
import static com.example.basicofkotlin.FunctionClass.mul;
import static com.example.basicofkotlin.FunctionClass.sub;
import static com.example.basicofkotlin.FunctionClass.sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class JavaPractical extends AppCompatActivity {

    ArrayList<String> history = new ArrayList<>();
    private EditText value1,value2;
    private TextView answer;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_java_practical);
        value1 = findViewById(R.id.txt_value1);
        value2 = findViewById(R.id.txt_value2);
        answer = findViewById(R.id.lbl_answer);
        calculate = findViewById(R.id.btn_calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    answer.setText("Addition: " + sum(Integer.parseInt(value1.getText().toString()),Integer.parseInt(value2.getText().toString())));

                    answer.setText(answer.getText().toString() + "\nSubtraction: " + sub(Integer.parseInt(value1.getText().toString()),Integer.parseInt(value2.getText().toString())));

                    answer.setText(answer.getText().toString() + "\nMultiplication: " + mul(Integer.parseInt(value1.getText().toString()),Integer.parseInt(value2.getText().toString())));

                    answer.setText(answer.getText().toString() + "\nDivision: " + div(Integer.parseInt(value1.getText().toString()),Integer.parseInt(value2.getText().toString())));

                    history.add(answer.getText().toString());
                } catch (Exception ex) {
                    answer.setText(ex.getMessage().toString());
                }
                answer.setText(history.toString());
            }
        });
        }
    }