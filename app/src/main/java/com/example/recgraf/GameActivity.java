package com.example.recgraf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {
    Button siguiente;
    Button recursividad;
    Button permutaciones;
    Button acerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        siguiente = (Button)findViewById(R.id.button2);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(GameActivity.this, ValPatron.class);
                startActivity(siguiente);
            }
        });
        recursividad = (Button)findViewById(R.id.btnrec);
        recursividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recursividad = new Intent(GameActivity.this, Recursividad.class);
                startActivity(recursividad);

            }
        });

        permutaciones = (Button)findViewById(R.id.btnper);
        permutaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent permutaciones = new Intent(GameActivity.this, Permutaciones.class);
                startActivity(permutaciones);
            }
        });

        acerca = (Button)findViewById(R.id.btnacerca);
        acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent acerca = new Intent(GameActivity.this, Acercade.class);
                startActivity(acerca);
            }
        });
    }
}