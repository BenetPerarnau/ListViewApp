package com.example.benet.listviewapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benet.listviewapp.R;
import com.example.benet.listviewapp.model.Contenido;

import java.util.List;

/**
 * Created by Benet on 03/02/15.
 */
public class MyListAdapter extends BaseAdapter {

    private Activity activity;
    private List<Contenido> data;
    private LayoutInflater inflater;
    private int item_layout;

    public MyListAdapter(Activity activity, List<Contenido> data, int item_layout) {
        this.activity = activity;
        this.data = data;
        this.item_layout = item_layout;

        this.inflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {//numero de items que te la llista
        return this.data.size();}

    @Override
    public Contenido getItem(int position) {//retorna el item de la pos indicada
        return this.data.get(position);}

    @Override
    public long getItemId(int position) {//retorna el id de la pos
        return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
/*
devuelve el layout del item que queremos visualizar.
Se llama a este método cada vez que se necesita mostrar un item de la lista en pantalla
(identificado por el índice position), se haya mostrado ya o no con anterioridad,
 */
        if(convertView==null){convertView=this.inflater.inflate(item_layout,null);}

        ImageView img=(ImageView)convertView.findViewById(R.id.item_img);
        TextView title=(TextView)convertView.findViewById(R.id.item_title);
        TextView subtitle=(TextView)convertView.findViewById(R.id.item_lugar_fecha);

        img.setImageResource(data.get(position).getImg());
        title.setText(data.get(position).getTitulo());
        subtitle.setText(data.get(position).getLugar()+"\t"+data.get(position).getFecha());

        return convertView;
    }
}
