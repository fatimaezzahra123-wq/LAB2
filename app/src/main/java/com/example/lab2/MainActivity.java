package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText inputNom, inputAdresse, inputSurface, inputPieces;
    CheckBox checkPiscine;
    Button btnCalcul;
    TextView resultBase, resultSupp, resultTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNom     = findViewById(R.id.input_nom);
        inputAdresse = findViewById(R.id.input_adresse);
        inputSurface = findViewById(R.id.input_surface);
        inputPieces  = findViewById(R.id.input_pieces);
        checkPiscine = findViewById(R.id.checkbox_piscine);
        btnCalcul    = findViewById(R.id.button_calcul);
        resultBase   = findViewById(R.id.result_base);
        resultSupp   = findViewById(R.id.result_supp);
        resultTotal  = findViewById(R.id.result_total);

        btnCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
            }
        });
    }
    private void calculer() {
        double surface  = Double.parseDouble(inputSurface.getText().toString());
        int    pieces   = Integer.parseInt(inputPieces.getText().toString());
        boolean piscine = checkPiscine.isChecked();

        double impotBase  = pieces  * 60.0;
        double impotSupp  = surface * 2.5;
        double impotTotal = impotBase + impotSupp;

        if (piscine) {
            impotTotal += 100.0;
        }

        resultBase.setText("Impôt de base         : " + impotBase);
        resultSupp.setText("Impôt supplémentaire  : " + impotSupp);
        resultTotal.setText("Impôt Total           : " + impotTotal);
    }
}