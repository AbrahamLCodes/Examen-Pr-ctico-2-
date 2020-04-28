package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

/*
 * Autor: Abraham Luna Cázares y Mario Andrés Tejada Morales
 * Carrera: Ingeniería Informática
 * Materia: Desarrollo de Aplicaciones Móviles I
 * Docente: Ing. Rubén Alonso Hernández Chávez
 * ---Instituto Tecnológico de Chihuahua II---
 * */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RestauranteActivity extends AppCompatActivity {

    private ListView listViewRes;
    Restaurante objects[];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listados);
        listViewRes = findViewById(R.id.mi_lista_restaurantes);

        //Método OnCreate, se inicializa la lista creando un arreglo de Restaurantes a partir del ArrayRestaurante
        Restaurante objects[] = new Restaurante[ArrayRestaurante.getArrayRestaurante().size()];
        for (int i = 0; i < ArrayRestaurante.getArrayRestaurante().size(); i++) {
            objects[i] = ArrayRestaurante.getArrayRestaurante().get(i);
        }

        listViewRes.setAdapter(new ResturanteAdapter(this, R.layout.costum_item, objects));

        listViewRes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Se envían los datos a la siguiente Activity mediante el método PutExtra
                Intent abrirRestaurante = new Intent(RestauranteActivity.this, EvaluacionActivity.class);

                abrirRestaurante.putExtra("nombre", ArrayRestaurante.getArrayRestaurante().get(position).getNombre());
                abrirRestaurante.putExtra("descripcion", ArrayRestaurante.getArrayRestaurante().get(position).getDescripcion());
                abrirRestaurante.putExtra("direccion", ArrayRestaurante.getArrayRestaurante().get(position).getDirytel());
                abrirRestaurante.putExtra("calificacion", ArrayRestaurante.getArrayRestaurante().get(position).getCalificacion());
                abrirRestaurante.putExtra("imagen", ArrayRestaurante.getArrayRestaurante().get(position).getImagen());
                abrirRestaurante.putExtra("restaurante", position);

                startActivity(abrirRestaurante);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();


        //Cuando se califica la lista se devuelve a esta actividad, aprovechando el ciclo de vida se actualiza de nuevo.
        Restaurante objects[] = new Restaurante[ArrayRestaurante.getArrayRestaurante().size()];
        for (int i = 0; i < ArrayRestaurante.getArrayRestaurante().size(); i++) {
            objects[i] = ArrayRestaurante.getArrayRestaurante().get(i);
        }

        listViewRes.setAdapter(new ResturanteAdapter(this, R.layout.costum_item, objects));
    }


}
