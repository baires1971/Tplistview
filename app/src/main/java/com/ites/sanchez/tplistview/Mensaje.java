package com.ites.sanchez.tplistview;

import android.graphics.Color;

/**
 * Created by Usuario on 9/9/2017.
 */

public class Mensaje {

    private long id;
    private String remitente;
    private String email;
    private String asunto;
    private String contenido;



    public Mensaje(long _id, String _remitente, String _email, String _asunto, String _contenido){
        id = _id;
        remitente = _remitente;
        email = _email;
        asunto = _asunto;
        contenido = _contenido;

    }

    public long getId() {
        return id;
    }

    public String getLetra(){
        String letra = remitente.substring(0,1);

    return  letra;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getEmail() {
        return email;
    }


    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public String getSubcontenido(){
        String subcontenido = contenido.substring(0,50);
        return subcontenido;
    }


    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }


}
