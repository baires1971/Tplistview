package com.ites.sanchez.tplistview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ites.sanchez.tplistview.Mensaje;
import com.ites.sanchez.tplistview.R;

import java.util.List;
import java.util.Random;

/**
 * Created by Usuario on 9/9/2017.
 */

public class mensajeAdapter extends BaseAdapter {
    private List<Mensaje> mensajes;

    public mensajeAdapter(List<Mensaje> mensajes){
        this.mensajes=mensajes;

    }

    @Override
    public int getCount() {
        return mensajes.size();
    }

    @Override
    public Object getItem(int position) {
        return mensajes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mensajes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

     View view;
        if(convertView == null)
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptermensaje, parent,false);
        else
        view = convertView;
        Mensaje mensaje = (Mensaje)getItem(position);
        TextView logo = (TextView) view.findViewById(R.id.txtlogo);
        TextView asunto = (TextView) view.findViewById(R.id.txtasunto);
        TextView contenido = (TextView) view.findViewById(R.id.txtsubcontenido);
        logo.setText(mensaje.getLetra());

        logo.getBackground().setColorFilter(getRandomColor(), PorterDuff.Mode.SRC);
        asunto.setText(mensaje.getAsunto());
        contenido.setText(mensaje.getSubcontenido());
        return view;
    }

    private  int getRandomColor() {
        Random random = new Random();
        int RGB = 0xff + 1;
        int colors ;
        int r1 = (int) Math.floor(Math.random() * RGB);
        int r2 = (int) Math.floor(Math.random() * RGB);
        int r3 = (int) Math.floor(Math.random() * RGB);
        colors = Color.rgb(r1, r2, r3);
        return colors;
    }


}
