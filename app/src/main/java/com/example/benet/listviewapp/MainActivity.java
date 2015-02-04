package com.example.benet.listviewapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.benet.listviewapp.Adapters.MyListAdapter;
import com.example.benet.listviewapp.model.Contenido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private List<Contenido> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDateModel();

        ListView listView=(ListView)findViewById(R.id.listView);
        MyListAdapter adapter=new MyListAdapter(this, data, R.layout.list_item);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    public void createDateModel(){
        data=new ArrayList<Contenido>();
        for(int i=0; i<10; i++){
            Calendar fecha=new GregorianCalendar();//La fecha actual
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date utilDate=null;
            try {
                utilDate = formatoDeFecha.parse(fecha.get(Calendar.YEAR)+"/"+fecha.get(Calendar.MONTH)+1+"/"+fecha.get(Calendar.DAY_OF_MONTH));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Contenido a=new Contenido("Titulo "+(i+1),"Lugar del titulo "+(i+1),utilDate,R.drawable.ic_launcher);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(this,data.get(position).getTitulo(), Toast.LENGTH_LONG).show();

    }
}
