package com.example.benet.listviewapp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Benet on 03/02/15.
 */
public class Contenido implements Serializable {

    private String titulo,lugar, desc;
    private Date fecha ;
    private int img;

    public Contenido(String titulo,String desc, String lugar, Date fecha, int img){

        setTitulo(titulo);
        setDesc(desc);
        setLugar(lugar);
        setFecha(fecha);
        setImg(img);
    }

    public String getTitulo() {return titulo;}
    public String getLugar() {return lugar;}
    public String getDesc(){return this.desc;}
    public Date getFecha() {return fecha;}
    public int getImg() {return img;}

    public void setDesc(String desc){this.desc=desc;}

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
