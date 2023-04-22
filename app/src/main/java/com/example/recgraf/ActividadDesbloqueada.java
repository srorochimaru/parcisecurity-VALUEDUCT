package com.example.recgraf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActividadDesbloqueada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_desbloqueada);
        Intent intent= new Intent(ActividadDesbloqueada.this, GameActivity.class);
        startActivity(intent);
    }
    public void play(View view){
        Intent intent = new Intent(ActividadDesbloqueada.this, GameActivity.class);
        startActivity(intent);
    }
}