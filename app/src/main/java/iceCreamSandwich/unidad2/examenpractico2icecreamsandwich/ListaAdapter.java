package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

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
