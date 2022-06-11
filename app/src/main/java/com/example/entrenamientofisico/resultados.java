package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.entrenamientofisico.db.dbinsert;

public class resultados extends AppCompatActivity {

    private Button regresar, reintentarEjercicio;
    private TextView categorianombre, cantEjercicios, kcal;
    private ImageView gifShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        regresar=(Button) findViewById(R.id.regresar);
        reintentarEjercicio = (Button) findViewById(R.id.reintentarRetry);
        Bundle getValue = getIntent().getExtras();
        String categoria = getIntent().getExtras().getString("categorias");
        int valueCat = getIntent().getExtras().getInt("valueData");

        categorianombre=(TextView) findViewById(R.id.nameEjercicio);
        cantEjercicios = (TextView) findViewById(R.id.cantidadEjercicios);
        gifShow = (ImageView) findViewById(R.id.gifTrofeo);
        kcal = (TextView) findViewById(R.id.calorias);


        Uri urlparse = null;
        urlparse = Uri.parse("https://media.giphy.com/media/Ya09HZXAIo3oWBnwmd/giphy.gif");
        Glide.with(getApplicationContext()).load(urlparse).into(gifShow);

        categorianombre.setText(categoria);
        cantEjer(valueCat);
        registerData();

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(resultados.this, MainActivity.class);
                startActivity(intent);
            }
        });

        reintentarEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reintentar(valueCat);
            }
        });
    }

    public void reintentar(int num){
        Bundle sendValue = new Bundle();
        sendValue.putInt("value", num);
        Intent intent = new Intent(resultados.this, activityExercicios.class);
        intent.putExtras(sendValue);
        startActivity(intent);
        finish();
    }

    public void cantEjer(int value){

        int nivel = 0;
        int result = 0;

        if(value == 1 || value == 4 || value == 7 || value == 10 || value == 13){
            cantEjercicios.setText("10");
            nivel = 1;
        }
        else if(value == 2 || value == 5 || value == 8 || value == 11 || value == 14){
            cantEjercicios.setText("20");
            nivel = 2;
        }
        else if(value == 3 || value == 6 || value == 9 || value == 12 || value == 15){
            cantEjercicios.setText("30");
            nivel = 3;
        }

        if(value == 1 || value == 2 || value == 3){
            result = 120 * nivel;
            String resultToString = String.valueOf(result);
            kcal.setText(resultToString);
        }
        else if(value == 4 || value == 5 || value == 6){
            result = 110 * nivel;
            String resultToString = String.valueOf(result);
            kcal.setText(resultToString);
        }
        else if(value == 7 || value == 8 || value == 9){
            result = 130 * nivel;
            String resultToString = String.valueOf(result);
            kcal.setText(resultToString);
        }
        else if(value == 10 || value == 11 || value == 12){
            result = 100 * nivel;
            String resultToString = String.valueOf(result);
            kcal.setText(resultToString);
        }
        else if(value == 13 || value == 14 || value == 15){
            result = 135 * nivel;
            String resultToString = String.valueOf(result);
            kcal.setText(resultToString);
        }

    }

    private void registerData(){
        dbinsert inser = new dbinsert(resultados.this);
        long id = inser.insertRegiste(categorianombre.getText().toString(), cantEjercicios.getText().toString(), kcal.getText().toString());

        if(id < 0){
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }
    }

}