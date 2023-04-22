package com.example.recgraf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Recursividad extends AppCompatActivity {
    private EditText numero;
    private Button jugar, reiniciar;
    private TextView mensaje;
    private int aleatorio;
    private int intentos = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursividad);
        numero=(EditText)findViewById(R.id.txtnumero);
        jugar = (Button)findViewById(R.id.btnaceptar);
        reiniciar = (Button)findViewById(R.id.btnreiniciar);
        mensaje = (TextView)findViewById(R.id.lblmensaje);
        reiniciar.setEnabled(false);
        aleatorio = generarAleatorio();
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numerousuario;
                numerousuario = Integer.parseInt(numero.getText().toString());
                if (aleatorio==numerousuario){
                    mensaje.setText("HAS GANADO");
                }else{
                    intentos = intentos -1;
                }
                if (intentos==0){
                    reiniciar.setEnabled(true);
                    jugar.setEnabled(false);
                    mensaje.setText("HAS PERDIDO");
                }
            }
        });
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentos = 3;
                reiniciar.setEnabled(false);
                mensaje.setText("");
                numero.setText("");
                aleatorio= generarAleatorio();
                jugar.setEnabled(true);
            }
        });
    }

    private int generarAleatorio(){
        return (int)(Math.random()*10+1);
    }
}