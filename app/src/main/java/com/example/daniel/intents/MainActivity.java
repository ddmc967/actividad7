package com.example.daniel.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText telefono, web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telefono = (EditText) findViewById(R.id.editText);
        web = (EditText) findViewById(R.id.editText2);

    }

    public void intentTelefono(View view) {
        String num = telefono.getText().toString();

        if (TextUtils.isDigitsOnly(num) && num.length() == 10) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + num));
            startActivity(intent);
        } else {
            telefono.setError("El telefono tiene que ser de 10 digitos");
        }
    }


    public void intentPagina(View view) {
        String url = web.getText().toString();

        if (URLUtil.isValidUrl(url)) {
            Intent intent2 = new Intent(Intent.ACTION_VIEW);
            intent2.setData(Uri.parse(url));
            startActivity(intent2);
        } else {
            web.setError("Debe ser una pagina valida");
        }
    }

    public void intentMapas(View view) {
        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}