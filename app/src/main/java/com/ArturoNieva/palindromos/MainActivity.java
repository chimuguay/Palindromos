package com.ArturoNieva.palindromos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ETpalabra;
    TextView textPanlindromo;
    TextView textLongitud;
    TextView textInversa;
    TextView textLetras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPanlindromo = findViewById(R.id.textPalindromo);
        textLongitud = findViewById(R.id.textLongitud);
        textInversa = findViewById(R.id.textInversa);
        textLetras = findViewById(R.id.textLetras);

        Button btnVerificar = findViewById(R.id.btnVerificar);
        ETpalabra = findViewById(R.id.ETpalabra);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verificar();
            }
        });

    }


    public void verificar(){

        String palabra = ETpalabra.getText().toString();
        String palabraAux = "";
        String letrasCoincidentes = "";

        for (int i=palabra.length()-1; i>=0; i--){
            palabraAux += palabra.charAt(i);
        }

        System.out.println(palabraAux);

        if (palabra.equals(palabraAux)){
            textPanlindromo.setText("Si");
        }else{
            textPanlindromo.setText("No");
        }

        /*
        char charAux, charRey;
        int contador, contadorRey=0;

        charRey = '.';
        for (int i = 0; i<palabra.length(); i++){
            charAux = palabra.charAt(i);
            contador=0;
            for (int j=0; i<palabra.length(); i++){

                if (palabra.charAt(j) == charAux)
                    contador++;
            }
            if (contadorRey < contador) {
                contadorRey = contador;
                charRey = charAux;
            }
        }

        */

        int mayorRepeticion = 0;
        char letraMasRepetida = '.';

        String texto = palabra;
        char[] letras = texto.toCharArray();

        for(int i=0; i<letras.length; i++){

            char letraActual = letras[i];
            int contador = 0;

            for (int j =0; j<letras.length; j++){
                if (letras[j] == letraActual)
                    contador++;
            }

            if(mayorRepeticion < contador)
            {
                mayorRepeticion = contador;
                letraMasRepetida = letraActual;
            }
        }

        if (mayorRepeticion == 1)
            letraMasRepetida = '.';


        textLetras.setText(String.valueOf(letraMasRepetida));
        textLongitud.setText(String.valueOf(palabra.length()));
        textInversa.setText(palabraAux);

    }

}
