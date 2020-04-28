package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

/*
 * Autor: Abraham Luna Cázares, Mario Andrés tejada Morales (No tiene computadora buena)
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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ResturanteAdapter extends ArrayAdapter<Restaurante> {
    Restaurante[] objects;
    Context context;
    int resource;

    public ResturanteAdapter(Context context, int resource, Restaurante[] objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {// primera vez, hay que crear el layout
            convertView = ((Activity) context).getLayoutInflater().inflate(resource, parent, false);

        }

        ImageView img_restaurante, star_low, star_medium, star_high;
        TextView txtdescripcion, txttitulo, txtdireytel;

        img_restaurante = convertView.findViewById(R.id.img_restaurant);
        txtdescripcion = convertView.findViewById(R.id.txt_descrip_res);
        txtdireytel = convertView.findViewById(R.id.txt_direc_tel);
        txttitulo = convertView.findViewById(R.id.txt_nom_res);
        star_high = convertView.findViewById(R.id.high);
        star_medium = convertView.findViewById(R.id.medium);
        star_low = convertView.findViewById(R.id.low);

        txtdescripcion.setText(objects[position].getDescripcion());
        txtdireytel.setText(objects[position].getDirytel());
        txttitulo.setText(objects[position].getNombre());
        img_restaurante.setImageResource(objects[position].getImagen());

        //validacion de la calificacion de las estrellas
        if (objects[position].getCalificacion() == 0) {
            star_low.setImageResource(R.drawable.grey);
            star_medium.setImageResource(R.drawable.grey);
            star_high.setImageResource(R.drawable.grey);
        } else if (objects[position].getCalificacion() == 1) {
            star_low.setImageResource(R.drawable.star);
            star_medium.setImageResource(R.drawable.grey);
            star_high.setImageResource(R.drawable.grey);
        } else if (objects[position].getCalificacion() == 2) {
            star_low.setImageResource(R.drawable.star);
            star_medium.setImageResource(R.drawable.star);
            star_high.setImageResource(R.drawable.grey);
        } else if (objects[position].getCalificacion() == 3) {
            star_low.setImageResource(R.drawable.star);
            star_medium.setImageResource(R.drawable.star);
            star_high.setImageResource(R.drawable.star);
        }
        return convertView;
    }
}
