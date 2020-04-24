package iceCreamSandwich.unidad2.examenpractico2icecreamsandwich;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView capturar;
    LinearLayout textLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLayout = findViewById(R.id.textLayout);

        capturar = findViewById(R.id.capturar);
        capturar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.capturar:
                startActivity(new Intent(this, DatosActivity.class));
                break;
        }
    }
}
