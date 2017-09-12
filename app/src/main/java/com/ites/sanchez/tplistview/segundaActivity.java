package com.ites.sanchez.tplistview;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;

public class segundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.ic_back);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        Bundle parametros = getIntent().getExtras();

        String p_remitente = parametros.getString("KEY_REMITENTE");
        String p_asunto = parametros.getString("KEY_ASUNTO");
        String p_contenido = parametros.getString("KEY_CONTENIDO");
        //referencia controles de UI
        TextView txtremitente = (TextView) findViewById(R.id.txtremitente);
        TextView txtasunto = (TextView) findViewById(R.id.txtasunto);
        EditText txtcontenido = (EditText) findViewById(R.id.txtcontenido);
        //asignacion parametros recuperados a UI
        txtremitente.setText(p_remitente);
        txtasunto.setText(p_asunto);
        txtcontenido.setText(p_contenido);
       // android.app.ActionBar actionBar = getActionBar();
       // actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menusecundario,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuOprimio:
                Toast.makeText(this,"Ha seleccionado la opcion oprimir",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnuvolver:
                Toast.makeText(this,"Ha seleccionado la opcion volver pantalla principal",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
