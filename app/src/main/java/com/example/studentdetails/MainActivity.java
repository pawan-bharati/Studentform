package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView;
    private String[] language = {"C", "C++", "Java", "C#", "iso", "Android", "Asp.Net", "PHP"};
    private Spinner spincountry;
    private String[] country = {"NEPAL", "US", "UK", "PAK", "IND"};
    EditText name;
    RadioGroup rdogrp;
    RadioButton rdoimg1, rdoimg2, rdoimg3;
    TextView tvview, tvview1, tvview2,tx1,tx2,tx3,tx4;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvview = findViewById(R.id.tvview);
        tvview1 = findViewById(R.id.tvview1);
        tvview2 = findViewById(R.id.tvview2);
        tx1=findViewById(R.id.tx1);
        tx2=findViewById(R.id.tx2);
        tx3=findViewById(R.id.tx3);
        tx4=findViewById(R.id.tx4);
        name = findViewById(R.id.name);
        btnsave = findViewById(R.id.btnsave);
        rdogrp = findViewById(R.id.rdogrp);
        rdoimg1 = findViewById(R.id.rdoimg1);
        rdoimg2 = findViewById(R.id.rdoimg2);
        rdoimg3 = findViewById(R.id.rdoimg3);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter stringArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.select_dialog_item,
                language
        );

        autoCompleteTextView.setAdapter(stringArrayAdapter);
        autoCompleteTextView.setThreshold(1);

        spincountry = findViewById(R.id.spincountry);

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                country
        );
        spincountry.setAdapter(arrayAdapter);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rdogrp.getCheckedRadioButtonId();
                RadioButton radioButton;
                radioButton =findViewById(selectedId);
                tx1.setText("Name: "+name.getText());
                tx2.setText("Gender: "+radioButton.getText());
                tx3.setText("Country: "+spincountry.getSelectedItem().toString());
                tx4.setText("Batch: "+autoCompleteTextView.getText());

            }
        });

    }

}

