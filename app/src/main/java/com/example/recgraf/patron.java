package com.example.recgraf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

import io.paperdb.Paper;

public class patron extends AppCompatActivity {
    //Se crean dos variables para guardar y comparar la contraseña
        String save_pattern_key = "pattern codigo";
        String final_pattern = "";
        PatternLockView mPatternLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patron);
        //Ocupar toda la pantalla
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Inicializar el panel
        Paper.init(this);
        final String save_pattern = Paper.book().read(save_pattern_key);
        if(save_pattern!= null && !save_pattern.equals("null")){
            setContentView(R.layout.activity_val_patron);
            mPatternLockView = findViewById(R.id.bloqueoPatronView);
            mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {
                }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {
                }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                //Se crea un String para guardar los números del patrón
                    final_pattern = PatternLockUtils.patternToString(mPatternLockView, pattern);
                    //Compara si el número que se ha escrito es igual al que se ha guardado
                    if (final_pattern.equals(save_pattern)){
                        Toast.makeText(patron.this, "Contraseña correcta", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(patron.this, GameActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(patron.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCleared() {
                }
            });
        }else{
            setContentView(R.layout.activity_patron);
            mPatternLockView =(PatternLockView) findViewById(R.id.bloqueoPatronView);
            mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {
                }
                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {
                }
                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                    final_pattern = PatternLockUtils.patternToString(mPatternLockView, pattern);
                }
                @Override
                public void onCleared() {
                }
            });
            Button btnguardar = (Button)findViewById(R.id.btnguardar);
            btnguardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Paper.book().write(save_pattern_key, final_pattern);
                    Toast.makeText(patron.this, "Patrón guardado correctamente", Toast.LENGTH_SHORT).show();
                    //Permite a la aplicación iniciar a partir de un patrón de seguridad
                    Intent intent = new Intent(patron.this, ValPatron.class);
                    startActivity(intent);
                }
            });
        }
    }
}