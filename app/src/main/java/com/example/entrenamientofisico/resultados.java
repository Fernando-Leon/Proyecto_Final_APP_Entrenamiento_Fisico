package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultados extends AppCompatActivity {

    private Button regresar;
    private TextView categorianombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        regresar=(Button) findViewById(R.id.regresar);
        Bundle getValue = getIntent().getExtras();
        String categoria = getIntent().getExtras().getString("categorias");

        categorianombre=(TextView) findViewById(R.id.nameEjercicio);

        categorianombre.setText(categoria);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(resultados.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}