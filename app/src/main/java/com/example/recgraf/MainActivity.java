package com.example.recgraf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //animaciones para arriba y para abajo
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamientoarriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamientoabajo);

        //imagen del principio
        ImageView logoImageView =findViewById(R.id.logo);
        //uso de la animacion
        logoImageView.setAnimation(animacion1);
        //transporte a otra activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, patron.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}