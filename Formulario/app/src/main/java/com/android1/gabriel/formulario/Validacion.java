package com.android1.gabriel.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Validacion extends AppCompatActivity {

    Button btnEditar, btnAceptar;
    TextView tvInfoEnviada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacion);

        btnEditar = (Button)findViewById(R.id.btnEditar);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);

        tvInfoEnviada = (TextView)findViewById(R.id.tvRespuesta);

        Bundle bundle = getIntent().getExtras();

        String dato  = bundle.getString("Info").toString();
        tvInfoEnviada.setText(dato);

        btnEditar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent editar = new Intent(Validacion.this, MainActivity.class);
                startActivity(editar);
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
