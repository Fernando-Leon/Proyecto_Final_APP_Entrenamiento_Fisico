package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_informes extends AppCompatActivity implements popupChangeImc.dialogChangeImc{

    //Bibliografias

    //https://www.youtube.com/watch?v=ARezg1D9Zd0
    //https://www.develou.com/como-crear-dialogos-en-android/#Crear_un_dialogo_personalizado

    private TextView pesoView;
    private TextView alturaView;
    private TextView imc;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informes);

        pesoView = (TextView) findViewById(R.id.valuePeso);
        alturaView = (TextView) findViewById(R.id.valueAltura);
        imc = (TextView) findViewById(R.id.resultadoImc);
        button = (Button) findViewById(R.id.abrirPopup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

            public void openDialog(){
                popupChangeImc pop = new popupChangeImc();
                pop.show(getSupportFragmentManager(), "Change Imc");
            }
        });
    }

    public void statusAjustes(View view) {
        Intent intent = new Intent(this, activity_ajustes.class);
        startActivity(intent);
    }

    public void statusEstadisticas(View view) {
        Intent intent = new Intent(this, activity_estadisticas.class);
        startActivity(intent);
    }

    public void statusInicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void applyTexts(String altura, String peso) {
        alturaView.setText(altura);
        pesoView.setText(peso);

        String getAltura = alturaView.getText().toString();
        String getPeso = pesoView.getText().toString();
        float floatAltura = Float.parseFloat(getAltura);
        float floatPeso = Float.parseFloat(getPeso);
        float imcResult =  floatPeso / (floatAltura * floatAltura);
        String imcString = String.valueOf(imcResult);
        imc.setText(imcString);
    }
}