package com.android1.gabriel.formulario;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.icu.util.Calendar.getInstance;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnfecha;
    EditText efecha;
    private int dia, mes, ano;

    Button btnEnviar;
    EditText etInfoEnviar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnfecha = (Button) findViewById(R.id.btnfecha);
        efecha = (EditText) findViewById(R.id.efecha);
        btnfecha.setOnClickListener(this);

        btnEnviar = (Button) findViewById(R.id.btnenviar);

        etInfoEnviar = (EditText) findViewById(R.id.etInfoEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Validacion.class);
                intent.putExtra("Info", etInfoEnviar.getText().toString());
                startActivity(intent);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v == btnfecha) {
            final Calendar c = getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    efecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }
                    , dia, mes, ano);
            datePickerDialog.show();
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
