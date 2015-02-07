package com.example.benet.listviewapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.benet.listviewapp.Adapters.MyListAdapter;
import com.example.benet.listviewapp.activity.DetailActivity;
import com.example.benet.listviewapp.model.Contenido;

import junit.framework.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener, AbsListView.MultiChoiceModeListener {

    private List<Contenido> data;
    public static String sendItem="sendItem";
    private ListView listView;
    private  MyListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDateModel();

        listView=(ListView)findViewById(R.id.listView);
        adapter=new MyListAdapter(this, data, R.layout.list_item);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        ///
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(this);
        ///
    }

    public void createDateModel(){
        data=new ArrayList<Contenido>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date convertedDate = new Date();
        Contenido a;
        String [] titles=this.getResources().getStringArray(R.array.listaTitulos);
        String [] locates=this.getResources().getStringArray(R.array.LugarTitulos);
        String [] fechas=this.getResources().getStringArray(R.array.fechas);
        String [] desc=this.getResources().getStringArray(R.array.descripciones);
        String [] img=this.getResources().getStringArray(R.array.img);

        for(int i=0; i<10; i++){
            try {
                convertedDate = dateFormat.parse(fechas[i]);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                 a = new Contenido(titles[i],
                        desc[i],
                        locates[i],
                        convertedDate,
                        getResources().getIdentifier(img[i], "drawable", getPackageName()));

            data.add(a);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_help:
                Toast.makeText(this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actions_plus:
                Toast.makeText(this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent=new Intent(this, DetailActivity.class);
            intent.putExtra(sendItem,data.get(position));
            startActivity(intent);
    }
    private Contenido itemSelected;
    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        itemSelected=(Contenido)listView.getItemAtPosition(position);
        mode.setTitle(itemSelected.getTitulo());
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.context_listview_menu,menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_edit:
                Toast.makeText(this,item.getTitle().toString()+" "+mode.getTitle(), Toast.LENGTH_SHORT).show();
                mode.finish();
                return true;
            case R.id.action_delete:
                Toast.makeText(this,item.getTitle().toString()+" "+mode.getTitle(), Toast.LENGTH_SHORT).show();
                mode.finish();
                data.remove(itemSelected);
                adapter.notifyDataSetChanged();
                listView.refreshDrawableState();
                return true;
            default:
                return false;
        }

    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}
