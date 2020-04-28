package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RestauranteActivity extends AppCompatActivity {
    private ListView listViewRes;
    ImageView img_restaurante;
    //conversion de del arrayRestaurante a un arreglo
    Restaurante [] restaurantes = ArrayRestaurante.getArrayRestaurante().toArray(new Restaurante[0]);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listados);

        listViewRes = findViewById(R.id.mi_lista_restaurantes);
        img_restaurante = findViewById(R.id.img_restaurant);

        listViewRes.setAdapter(new ResturanteAdapter(this,R.layout.costum_item,restaurantes));
    }
}
