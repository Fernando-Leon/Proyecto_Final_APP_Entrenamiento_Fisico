package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class avisos extends AppCompatActivity {

    private Button botonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos);

        botonRegresar = (Button) findViewById(R.id.returnAjustes);

        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToAjustes();
            }
        });
    }

    private void returnToAjustes(){
        Intent intent = new Intent(this, activity_ajustes.class);
        startActivity(intent);
    }
}