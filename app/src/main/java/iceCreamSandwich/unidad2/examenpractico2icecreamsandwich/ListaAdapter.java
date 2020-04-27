package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

/*
 * Autor: Abraham Luna Cázares
 * Carrera: Ingeniería Informática
 * Materia: Desarrollo de Aplicaciones Móviles I
 * Docente: Ing. Rubén Alonso Hernández Chávez
 * ---Instituto Tecnológico de Chihuahua II---
 * */

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListaAdapter extends ArrayAdapter<ListaImagenes> {

    private ListaImagenes[] objects;
    private Context context;
    private int resource;

    //Constructor override para inicializar los objetos, el context y el recurso que se usará para el Adapter
    public ListaAdapter(@NonNull Context context, int resource, @NonNull ListaImagenes[] objects) {
        super(context, resource, objects);

        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){//Primera vez que se ejecuta la App
            convertView = ((Activity) context).getLayoutInflater().inflate(resource,parent,false);
        }

        ImageView imagen = convertView.findViewById(R.id.imagen);
        imagen.setImageResource(objects[position].getImagenRecurso());

        return convertView;
    }
}
