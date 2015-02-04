package com.example.benet.listviewapp.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.benet.listviewapp.MainActivity;
import com.example.benet.listviewapp.R;
import com.example.benet.listviewapp.model.Contenido;

public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity2);

        ImageView img=(ImageView)findViewById(R.id.img);
        TextView title=(TextView)findViewById(R.id.txtTitulo);
        TextView desc=(TextView)findViewById(R.id.txtDesc);
        TextView lugar=(TextView)findViewById(R.id.txtLugar);
        TextView fecha=(TextView)findViewById(R.id.txtFecha);

        Intent intent=getIntent();
        Contenido object=(Contenido)intent.getSerializableExtra(MainActivity.sendItem);

        img.setImageResource(object.getImg());
        title.setText(object.getTitulo());
        desc.setText(object.getDesc());
        lugar.setText(object.getLugar());
        fecha.setText(object.getFecha()+"");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(this, this.getResources().getString(R.string.action_settings), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_help:
                Toast.makeText(this,this.getResources().getString(R.string.action_help),Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actions_plus:
                Toast.makeText(this,this.getResources().getString(R.string.action_plus),Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
