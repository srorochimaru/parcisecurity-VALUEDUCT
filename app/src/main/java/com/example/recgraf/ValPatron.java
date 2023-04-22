package com.example.recgraf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

import io.paperdb.Paper;

public class ValPatron extends AppCompatActivity {
    //Se crean dos variables para guardar y comparar la contraseña
    String save_pattern_key = "pattern codigo";
    String final_pattern = "";
    PatternLockView mPatternLockView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_val_patron);

        //Inicializar el panel
        Paper.init(this);
        final String save_pattern = Paper.book().read(save_pattern_key);
        if(save_pattern!= null && !save_pattern.equals("null")) {
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
                    if (final_pattern.equals(save_pattern)) {
                        Toast.makeText(ValPatron.this, "Contraseña correcta", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ValPatron.this, GameActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ValPatron.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCleared() {

                }
            });
        }
    }
}