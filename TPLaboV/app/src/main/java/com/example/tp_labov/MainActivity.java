package com.example.tp_labov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback, SearchView.OnQueryTextListener {
    public static List<StarWarsModel> listPer =new ArrayList<StarWarsModel>();
    public static List<StarWarsModel> listPerAux =new ArrayList<StarWarsModel>();
    private AdapterSW adapterSW;
     public Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //genero la cola de mesajeria
        this.handler=new Handler(this);
        Thread ts= new Thread(new ConsultasHTTP("https://swapi.dev/api/people/",handler));
        ts.start();

        this.adapterSW= new AdapterSW(listPer,this.handler);
        RecyclerView rv=super.findViewById(R.id.rvPersona);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapterSW);

    }

    @Override
    public boolean handleMessage(@NonNull Message message) {

        adapterSW.personas=(List<StarWarsModel>)message.obj;
        adapterSW.notifyDataSetChanged();

       // TextView tvApi= this.findViewById(R.id.api);
        //tvApi.setText(message.obj.toString());
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.buscar){
            return true;
           // super.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        //sacamos el item
        MenuItem mi=menu.findItem(R.id.buscar);
        //sacamos el action view
        SearchView sv =(SearchView) mi.getActionView();
        //y lo seteamos
        sv.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        Log.d("onQueryTextSubmit",s);


        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("LISTAe",listPerAux.toString());
        Log.d("onQueryTextChange",newText);
        List<StarWarsModel> listPerClone =new ArrayList<StarWarsModel>();
        //listPerAux=adapterSW.personas;
            listPerClone.clear();
            for (StarWarsModel auxPersona : listPerAux) {
                if (auxPersona.getName().toLowerCase().contains(newText.toLowerCase())) {
                    listPerClone.add(auxPersona);
                    Log.d("PRUEBA", "ESTOY ACA ");
                }
            }


    Log.d("hola",listPerClone.toString());
        adapterSW.personas.clear();
        adapterSW.personas.addAll(listPerClone);
        adapterSW.notifyDataSetChanged();
        return false;

    }
}