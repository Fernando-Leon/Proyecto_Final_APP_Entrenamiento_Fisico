package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_estadisticas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
    }

    public void statusInicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void statusAjustes(View view) {
        Intent intent = new Intent(this, activity_ajustes.class);
        startActivity(intent);
    }

    public void statusInformes(View view) {
        Intent intent = new Intent(this, activity_informes.class);
        startActivity(intent);
    }
}