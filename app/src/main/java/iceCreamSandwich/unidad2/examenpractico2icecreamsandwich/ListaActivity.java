package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

/*
 * Autor: Abraham Luna Cázares
 * Carrera: Ingeniería Informática
 * Materia: Desarrollo de Aplicaciones Móviles I
 * Docente: Ing. Rubén Alonso Hernández Chávez
 * ---Instituto Tecnológico de Chihuahua II---
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListaActivity extends AppCompatActivity {
    //Este código está basado en la práctica del ArrayAdapter del clima.


    private ListView listView;
    // Lista de imágenes que se pasará al ListaAdapter
    private ListaImagenes [] imagenes = {
            new ListaImagenes(R.drawable.carne),
            new ListaImagenes(R.drawable.carnitas),
            new ListaImagenes(R.drawable.pollo),
            new ListaImagenes(R.drawable.frijoles),
    };

    private int recurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listView = findViewById(R.id.listaDeImagenes);
        listView.setAdapter(new ListaAdapter(this,R.layout.mi_layout,imagenes));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        recurso = R.drawable.carne;
                        break;
                    case 1:
                        recurso = R.drawable.carnitas;
                        break;
                    case 2:
                        recurso = R.drawable.pollo;
                        break;
                    case 3:
                        recurso = R.drawable.frijoles;
                        break;
                }
                if(recurso != 0){
                    DatosActivity.setImagenRestaurant(recurso);
                    finish();
                }
            }
        });
    }
}
