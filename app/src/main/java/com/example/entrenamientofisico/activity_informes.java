package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_informes extends AppCompatActivity {

    //Bibliografias

    //https://www.youtube.com/watch?v=ARezg1D9Zd0
    //https://www.develou.com/como-crear-dialogos-en-android/#Crear_un_dialogo_personalizado

    private TextView peso;
    private TextView altura;
    private TextView imc;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informes);

        peso = (TextView) findViewById(R.id.valuePeso);
        altura = (TextView) findViewById(R.id.valueAltura);
        imc = (TextView) findViewById(R.id.resultadoImc);
        button = (Button) findViewById(R.id.abrirPopup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

            private void openDialog(){
                popupChangeImc pop = new popupChangeImc();
                pop.show(getSupportFragmentManager(), "Change Imc");
            }
        });


        String val1 = altura.getText().toString();
        String val2 = peso.getText().toString();
        float alt = Float.parseFloat(val1);
        float pes = Float.parseFloat(val2);
        float resultado = pes / (alt * alt);
        String x = String.valueOf(resultado);
        imc.setText(x);
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

    public void abrirPopup(View view) {

    }
}