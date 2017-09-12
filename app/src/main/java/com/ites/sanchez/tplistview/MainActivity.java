package com.ites.sanchez.tplistview;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.y;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    private List<Mensaje> mensajes;
    private ListView listamensajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.ic_carta);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        llenarmensajes();
        listamensajes = (ListView) findViewById(R.id.lista_mensajes);
        listamensajes.setAdapter(new mensajeAdapter(mensajes));

        listamensajes.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Mensaje mensajeseleccionado = (Mensaje) listamensajes.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this , segundaActivity.class);
                intent.putExtra("KEY_REMITENTE",mensajeseleccionado.getRemitente());
                intent.putExtra("KEY_ASUNTO",mensajeseleccionado.getAsunto());
                intent.putExtra("KEY_CONTENIDO",mensajeseleccionado.getContenido());
                startActivity(intent);
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuprincipal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuSalir:
                Toast.makeText(MainActivity.this,"Ha selecccionado la opcion salir del programa",Toast.LENGTH_SHORT).show();
                finish();
                return true;
            case R.id.mnurefresh:
                Toast.makeText(MainActivity.this,"Ha selecccionado la opcion refrescar la pantalla",Toast.LENGTH_SHORT).show();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void llenarmensajes(){
        long[] id = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        String[] remitente = getResources().getStringArray(R.array.arrayremitente);
        String[] email = getResources().getStringArray(R.array.arrayemail) ;
        String[] asunto = getResources().getStringArray(R.array.arrayasunto) ;
        String[] contenido = getResources().getStringArray(R.array.arraycontenido) ;
        mensajes = new ArrayList<Mensaje>();
        for(int i=0; i < id.length ; i++){
            mensajes.add(new Mensaje(id[i],remitente[i],email[i],asunto[i],contenido[i]));
        }
    }

}
