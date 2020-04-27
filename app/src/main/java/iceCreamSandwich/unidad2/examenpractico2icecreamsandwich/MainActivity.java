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
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView capturar, mostrar, salir;
    LinearLayout textLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLayout = findViewById(R.id.textLayout);

        capturar = findViewById(R.id.capturar);
        capturar.setOnClickListener(this);

        mostrar = findViewById(R.id.mostrar);
        mostrar.setOnClickListener(this);

        salir = findViewById(R.id.salir);
        salir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.capturar:
                startActivity(new Intent(this, DatosActivity.class));
                break;

            case R.id.mostrar:
                break;

            case R.id.salir:
                android.os.Process.killProcess(android.os.Process.myPid());
                break;

        }
    }
}
