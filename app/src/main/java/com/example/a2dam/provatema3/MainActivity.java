package com.example.a2dam.provatema3;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    EditText dia, mes, dinero;
    Button botonGuardar, botonMostrar;
    TextView mostrarTexto;
    public static final String PREFS = "Mis preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dia = (EditText)findViewById(R.id.dia);
        mes = (EditText)findViewById(R.id.mes);
        dinero = (EditText)findViewById(R.id.dinero);
        botonGuardar = (Button)findViewById(R.id.botonGuardar);
        botonMostrar = (Button)findViewById(R.id.botonMostrar);
        mostrarTexto = (TextView)findViewById(R.id.mostrarTexto);

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences(PREFS,MainActivity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("dia",dia.getText().toString());
                editor.putString("mes",mes.getText().toString());
                editor.putString("dinero",dinero.getText().toString());
                editor.commit();
            }
        });

        botonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences(PREFS,MainActivity.MODE_PRIVATE);
                mostrarTexto.setText
                        ("Dia: "+sp.getString("dia","")+"\n"+
                                "Mes: "+sp.getString("mes","")+"\n"+"Dinero: "+sp.getString("dinero",""));

            }
        });

    }
}
