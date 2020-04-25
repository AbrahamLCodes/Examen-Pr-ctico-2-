package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class DatosActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    Basandonos en la Arquitectura de Stacks de las Activities, podemos modificar la imágen del restaurante
    mediante una variable estática (Para no crear objetos nuevos) desde la lista de imágenes, a fin de cuentas
    esta Activity pasara a OnPause, no en OnDestroy.
    */

    private static ImageView imagenRestaurant;

    //Arreglos para los campos para optimizar uso de memoria y no escribir tantas líneas de código
    private String [] camposTexto = new String[3];
    private EditText[] campos = new EditText[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        imagenRestaurant = findViewById(R.id.imagenRestaurant);
        imagenRestaurant.setImageResource(R.drawable.carne);
        imagenRestaurant.setOnClickListener(this);

        inicializarCampos();
        inicializarStrings();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guardatBtn:

                break;
            case R.id.imagenRestaurant:
                startActivity(new Intent(this, ListaActivity.class));
                break;
        }
    }

    private void inicializarCampos(){
        for(int i = 0; i < 3 ; i++){
            campos[i] = findViewById(getResources().getIdentifier("campo"+i, "EditText", getPackageName()));
        }
    }

    private void inicializarStrings(){
        for (int i = 0 ; i < 3; i++){
            camposTexto[i] = "";
        }
    }

    public static void setImagenRestaurant(int recurso){
        imagenRestaurant.setImageResource(recurso);
    }
}
