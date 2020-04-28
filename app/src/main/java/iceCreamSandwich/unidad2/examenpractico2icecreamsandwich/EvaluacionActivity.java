package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

/*
 * Autor: Abraham Luna Cázares, Y Nevin Adair Almaza Ortiz
 * Carrera: Ingeniería Informática
 * Materia: Desarrollo de Aplicaciones Móviles I
 * Docente: Ing. Rubén Alonso Hernández Chávez
 * ---Instituto Tecnológico de Chihuahua II---
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EvaluacionActivity extends AppCompatActivity implements View.OnClickListener {

    private Bundle datos;
    private TextView nom, des, dir;
    private ImageView imagen1, imagen2, imagen3, imagenRestaurante;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);

        // nombre, descripcion, direccion, calificacion, imagen
        datos = getIntent().getExtras();

        index = datos.getInt("restaurante");

        nom = findViewById(R.id.nombre);
        des = findViewById(R.id.descripcion);
        dir = findViewById(R.id.direccion);
        imagen1 = findViewById(R.id.estrella1);
        imagen2 = findViewById(R.id.estrella2);
        imagen3 = findViewById(R.id.estrella3);
        imagenRestaurante = findViewById(R.id.imagenEvaulacion);

        nom.setText(datos.getString("nombre"));
        des.setText(datos.getString("descripcion"));
        dir.setText(datos.getString("direccion"));
        imagenRestaurante.setImageResource(datos.getInt("imagen"));


        switch (datos.getInt("calificacion")) {
            case 0:
                sinCalificacion();
                break;

            case 1:
                bajaCalificacion();
                break;

            case 2:
                mediaCalificacion();
                break;

            case 3:
                altaCalificacion();
                break;
        }

        imagen1.setOnClickListener(this);
        imagen2.setOnClickListener(this);
        imagen3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.estrella1:
                bajaCalificacion();
                ArrayRestaurante.getArrayRestaurante().get(index).setCalificacion(1);
                Toast.makeText(this, "¡Calificación guardada!", Toast.LENGTH_SHORT).show();
                finish();
                break;

            case R.id.estrella2:
                mediaCalificacion();
                ArrayRestaurante.getArrayRestaurante().get(index).setCalificacion(2);
                Toast.makeText(this, "¡Calificación guardada!", Toast.LENGTH_SHORT).show();
                finish();
                break;

            case R.id.estrella3:
                altaCalificacion();
                ArrayRestaurante.getArrayRestaurante().get(index).setCalificacion(3);
                Toast.makeText(this, "¡Calificación guardada!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

    private void sinCalificacion(){
        imagen1.setImageResource(R.drawable.grey);
        imagen2.setImageResource(R.drawable.grey);
        imagen3.setImageResource(R.drawable.grey);
    }

    private void bajaCalificacion(){
        imagen1.setImageResource(R.drawable.star);
        imagen2.setImageResource(R.drawable.grey);
        imagen3.setImageResource(R.drawable.grey);
    }

    private void mediaCalificacion(){
        imagen1.setImageResource(R.drawable.star);
        imagen2.setImageResource(R.drawable.star);
        imagen3.setImageResource(R.drawable.grey);
    }

    private void altaCalificacion(){
        imagen1.setImageResource(R.drawable.star);
        imagen2.setImageResource(R.drawable.star);
        imagen3.setImageResource(R.drawable.star);
    }
}
