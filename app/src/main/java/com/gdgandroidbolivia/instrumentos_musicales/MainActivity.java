package com.gdgandroidbolivia.instrumentos_musicales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements InstrumentoAdapter.onInstrumentoSelectedListener{
    RecyclerView instrumentosRecyclerView;
    InstrumentoAdapter instrumentoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instrumentosRecyclerView =(RecyclerView)findViewById(R.id.recycler_main);
        instrumentosRecyclerView.setHasFixedSize(true);
        instrumentosRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        instrumentoAdapter = new InstrumentoAdapter(this,this);
        llenarDatos();
        instrumentosRecyclerView.setAdapter(instrumentoAdapter);

    }
    private void llenarDatos() {
        List<Instrumento> lista = new ArrayList<>();
        lista.add(new Instrumento(R.drawable.bateria, " Bateria", getString(R.string.Descripcion_bateria)));
        lista.add(new Instrumento(R.drawable.guitarra, "Guitarra Acustica", getString(R.string.Descripcion_guitarra)));
        lista.add(new Instrumento(R.drawable.guitarraelectrica, "Guitarra Electrica", getString(R.string.Descripcion_guitarraelectrica)));
        lista.add(new Instrumento(R.drawable.saxofon, "Saxofon", getString(R.string.Descripcion_saxofon)));
        lista.add(new Instrumento(R.drawable.arpa, "Arpa", getString(R.string.Descripcion_arpa)));
        lista.add(new Instrumento(R.drawable.pandereta, "Pandereta", getString(R.string.Descripcion_pandereta)));
        lista.add(new Instrumento(R.drawable.piano, "Piano", getString(R.string.Descripcion_piano)));
        lista.add(new Instrumento(R.drawable.violin, "Violin", getString(R.string.Descripcion_violin)));
        lista.add(new Instrumento(R.drawable.teclado, "Teclado", getString(R.string.Descripcion_teclado)));

        instrumentoAdapter.setDataset(lista);
    }


    @Override
    public void onInstrumentoSelected(Instrumento instrumento) {
        Intent intent = new Intent(MainActivity.this,DetalleActivity.class);
        /*intent.putExtra("dato", instrumento);*/
        Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }
}
