/*
        Copyright (C) {2022} {Chouaib Sid}

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

        GNU GENERAL PUBLIC LICENSE
        Version 3, 29 June 2007

        Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
        Everyone is permitted to copy and distribute verbatim copies
        of this license document, but changing it is not allowed.
        */
package com.example.simpleinheritanceinislam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button calculate;
EditText totalIn, malesIn, femalesIn;
TextView resultView;
double maleshares, femaleshares;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalIn = findViewById(R.id.totalIn);
        malesIn = findViewById(R.id.malesIn);
        femalesIn = findViewById(R.id.femalesIn);
        resultView = findViewById(R.id.textView5);
        calculate = findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateInheritance();
            }
        });

    }


    public void calculateInheritance(){
    int maleNbr, femaleNbr;
    float total, shares;
    total = Float.parseFloat(totalIn.getText().toString());
    maleNbr = Integer.parseInt(malesIn.getText().toString());
    femaleNbr = Integer.parseInt(femalesIn.getText().toString());

        if(maleNbr == 0 && femaleNbr == 1) {
            femaleshares = (total / 2);
            resultView.setText("She gets: " +femaleshares +"DA.");
        }

        if(maleNbr == 1 && femaleNbr == 0) {

            resultView.setText("He inherits everything, which is: " +total +"DA.");
        }

        else if(maleNbr == 0 && femaleNbr >= 2) {
            shares = (total / 3) * 2;
            femaleshares = shares / femaleNbr;
            resultView.setText("The total share of the female children is: " +shares +"DA.\nEach one gets: " +femaleshares +"DA.");
        }

        else if(maleNbr >= 1 && femaleNbr >= 1) {
            shares = total / ((maleNbr * 2) + femaleNbr);
            femaleshares = shares;
            maleshares = shares * 2;
            resultView.setText("Each male gets: " + maleshares +"DA.\nEach female gets: " +femaleshares +"DA.");
        }
        else {
            resultView.setText("This case is not included");
        }
    }
}