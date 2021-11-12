package com.example.recyclercard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        //Declarar un Reciclar y un adaptador
    RecyclerView recyclerUsuario;
    UsuarioAdaptador usuarioAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarElementos();
    }
    public void inicializarElementos(){
        recyclerUsuario = findViewById(R.id.recycler); //Se asocia a la xml
        recyclerUsuario.setLayoutManager(new LinearLayoutManager(this));
        List<Usuario>usuarioList = new ArrayList<>();//Se define estructura de datos
        //Para usar los metodos como add entre otros de la clase list

        //Se cargaran datos de prueba mediante un ciclo For
        //Este ciclo puede cargar los datos de una fuente de datos como una base de datos
        for(int i=0; i<20; i++){
            usuarioList.add(new Usuario(i,("Nombre..." + i),"ApellidoX", "mail@mail.com",
                    "https://s22.postimg.cc/572fvlmg1/vlad-baranov-767980-unsplash.jpg"));
            Log.d("Msg","Se ha creado el creado el objeto:"+usuarioList.size());
        }
        usuarioAdaptador = new UsuarioAdaptador(usuarioList,this);
        recyclerUsuario.setAdapter(usuarioAdaptador);//Relacionando el Recycler con su adaptador
        Log.d("Msg","El tamaño de la lista es: "+usuarioList.size());

    }
}