package com.example.recgraf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Permutaciones extends AppCompatActivity implements View.OnClickListener {
    double [][] arreglo = new double[3][3];
    EditText edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permutaciones);
        setContentView(R.layout.activity_permutaciones);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        edit4 = findViewById(R.id.edit4);
        edit5 = findViewById(R.id.edit5);
        edit6 = findViewById(R.id.edit6);
        edit7 = findViewById(R.id.edit7);
        edit8 = findViewById(R.id.edit8);
        edit9 = findViewById(R.id.edit9);

        text1 = findViewById(R.id.texto1);
        text2 = findViewById(R.id.texto2);
        text3 = findViewById(R.id.texto3);
        text4 = findViewById(R.id.texto4);
        text5 = findViewById(R.id.texto5);
        text6 = findViewById(R.id.texto6);
        text7 = findViewById(R.id.texto7);
        text8 = findViewById(R.id.texto8);
        text9 = findViewById(R.id.texto9);

        View boton = findViewById(R.id.btn);
        boton.setOnClickListener(this);
    }
    public void onClick(View view){
        arreglo[0][0] = Double.parseDouble(edit1.getText().toString());
        arreglo[0][1] = Double.parseDouble(edit2.getText().toString());
        arreglo[0][2] = Double.parseDouble(edit3.getText().toString());

        arreglo[1][0] = Double.parseDouble(edit4.getText().toString());
        arreglo[1][1] = Double.parseDouble(edit5.getText().toString());
        arreglo[1][2] = Double.parseDouble(edit6.getText().toString());

        arreglo[2][0] = Double.parseDouble(edit7.getText().toString());
        arreglo[2][1] = Double.parseDouble(edit8.getText().toString());
        arreglo[2][2] = Double.parseDouble(edit9.getText().toString());

        //Arreglo por el cual se van a guardar los valores y ordenarlos en el sisguiente arreglo.


        Double aux;

        for (int i = 0; i<3; i++)
            for (int j = 0; j<3; j++){
                int z = j;
                for (int x = i; x<3; x++){
                    for (int y = z; y<3; y++)
                        if(arreglo[i][j] > arreglo[x][y]){
                            aux = arreglo[x][y];
                            arreglo[x][y] = arreglo[i][j];
                            arreglo[i][j] = aux;
                        }
                    z = 0;
                }
            }
        text1.setText(""+arreglo[0][0]);
        text2.setText(""+arreglo[0][1]);
        text3.setText(""+arreglo[0][2]);

        text4.setText(""+arreglo[1][0]);
        text5.setText(""+arreglo[1][1]);
        text6.setText(""+arreglo[1][2]);

        text7.setText(""+arreglo[2][0]);
        text8.setText(""+arreglo[2][1]);
        text9.setText(""+arreglo[2][2]);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}