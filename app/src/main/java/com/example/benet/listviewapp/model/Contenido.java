package com.example.benet.listviewapp.model;

import java.util.Date;

/**
 * Created by Benet on 03/02/15.
 */
public class Contenido {

    private String titulo,lugar;
    private Date fecha ;
    private int img;

    public Contenido(String titulo, String lugar, Date fecha, int img){

        setTitulo(titulo);
        setLugar(lugar);
        setFecha(fecha);
        setImg(img);
    }

    public String getTitulo() {return titulo;}
    public String getLugar() {return lugar;}
    public Date getFecha() {return fecha;}
    public int getImg() {return img;}

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
