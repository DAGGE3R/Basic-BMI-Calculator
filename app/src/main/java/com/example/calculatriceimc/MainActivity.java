package com.example.calculatriceimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calc = (Button) findViewById(R.id.btn);
        final EditText taille = (EditText) findViewById(R.id.taille);
        final EditText poids = (EditText) findViewById(R.id.poids);
        final TextView res = (TextView) findViewById(R.id.res);
        calc.setOnClickListener(x -> {
            if (taille.getText().length() > 0 && poids.getText().length() > 0) {
                double taille1 = Double.parseDouble(taille.getText().toString());
                double poids1 = Double.parseDouble(poids.getText().toString());
                double imc = CalculateIMC(poids1, taille1);
                if (imc < 16) {
                    res.setText(String.format("Votre IMC est : %s Vous etes trop maigre", new DecimalFormat("##,##").format(imc)));
                } else if (imc < 18.5) {
                    res.setText(String.format("Votre IMC est : %s Vous etes maigre", new DecimalFormat("##,##").format(imc)));
                } else if (imc < 25) {
                    res.setText(String.format("Votre IMC est : %s Vous etes normal", new DecimalFormat("##,##").format(imc)));
                } else if (imc < 30) {
                    res.setText(String.format("Votre IMC est : %s Vous etes Gros(se)", new DecimalFormat("##,##").format(imc)));
                } else
                    res.setText(String.format("Votre IMC est : %s Vous etes Obese", new DecimalFormat("##,##").format(imc)));

            }
        });
    }

    public double CalculateIMC(double x, double y) {
        if (y > 10) {
            y = y / 100;
        }
        return x / (y * y);
    }
}