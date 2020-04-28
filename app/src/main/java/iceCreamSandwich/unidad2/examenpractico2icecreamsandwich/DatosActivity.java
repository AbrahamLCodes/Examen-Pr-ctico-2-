package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

/*
 * Autor: Abraham Luna Cázares
 * Carrera: Ingeniería Informática
 * Materia: Desarrollo de Aplicaciones Móviles I
 * Docente: Ing. Rubén Alonso Hernández Chávez
 * ---Instituto Tecnológico de Chihuahua II---
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DatosActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    Basándonos en la Arquitectura de Stacks de las Activities, podemos modificar la imágen del restaurante
    mediante una variable estática (Para no crear objetos nuevos) desde la lista de imágenes, a fin de cuentas
    esta Activity pasará a OnPause, no en OnDestroy.
    */
    private static ImageView imagenRestaurant;
    private static int imagenRecurso;

    //Arreglos para los campos para optimizar uso de memoria y no escribir tantas líneas de código
    private String [] camposTexto = new String[3];
    private EditText[] campos = new EditText[3];
    private Button guardarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        imagenRestaurant = findViewById(R.id.imagenRestaurant);
        imagenRecurso = R.drawable.carne;
        imagenRestaurant.setImageResource(R.drawable.carne);
        imagenRestaurant.setOnClickListener(this);

        guardarBtn = findViewById(R.id.guardatBtn);
        guardarBtn.setOnClickListener(this);

        inicializarCampos();
        inicializarStrings();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guardatBtn:
                guardar();
                break;
            case R.id.imagenRestaurant:
                startActivity(new Intent(this, ListaActivity.class));
                break;
        }
    }

    /*
    Este método nos permite obtener el ID mediante el nombre que lo identifica. Método ideal para
    jugar con el iterador del ciclo for y no escribir asignaciones manuales.
    */
    private void inicializarCampos(){
        for(int i = 0; i < 3 ; i++){
            campos[i] = findViewById(getResources().getIdentifier("campo"+i, "id", getPackageName()));
        }
    }

    private void inicializarStrings(){
        for (int i = 0 ; i < 3; i++){
            camposTexto[i] = "";
        }
    }

    //Método para mandar a llamar al Botón de guardar.
    private void guardar(){
        /*
         Se implementa el métdo de banderas y algunos algoritmos de búsquedas de Estructuras de datos
         para verificar que todos los campos estén llenos
        */
        boolean correcto = true;
        for(EditText editTexts : campos ){
            if(String.valueOf(editTexts.getText()).equals("")){
                correcto = false;
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                break;
            }
        }

        //Si la bandera es correcta significa que los datos ya están validados. Se hace la asignación al arreglo de Strings.
        if(correcto){
            for (int i = 0 ; i < 3; i++){
                camposTexto[i] = String.valueOf(campos[i].getText());
            }
            guardarRestaurante();
            finish();
        }
    }

    /* Método para guardar objetos de tipo restaurante en el Array de Restaurantes. los métodos de la clase
        se explican más a detalle en la clase ArrayRestaurante.
    */
    private void guardarRestaurante(){
        ArrayRestaurante.add(new Restaurante(camposTexto, 0, imagenRecurso));
        Toast.makeText(this, "¡Datos guardados correctamente!", Toast.LENGTH_SHORT).show();
    }

    /*
    Configura la imágen del restuarante y la del recurso que se guardará en el objeto Restaurante.
    Lástima que no exista un método tipo: getImageResource. Las APIs de Android son muy extrañas.
    */
    public static void setImagenRestaurant(int recurso){
        imagenRestaurant.setImageResource(recurso);
        imagenRecurso = recurso;
    }
}
