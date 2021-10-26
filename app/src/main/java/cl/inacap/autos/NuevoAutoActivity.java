package cl.inacap.autos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import cl.inacap.autos.modelo.Auto;
import cl.inacap.autos.modelo.ListaDeAutos;

public class NuevoAutoActivity extends AppCompatActivity {

    private ListaDeAutos listaDeAutos=ListaDeAutos.getInstancia();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_auto);

    }

    public void ingresarNuevo(View view){
        String marca=((EditText) findViewById(R.id.ingresarMarca)).getText().toString();
        String color=((Spinner)findViewById(R.id.ingresarColor)).getSelectedItem().toString();
        String otroColor=((EditText)findViewById(R.id.otroColor)).getText().toString();


        if (marca.isEmpty()){
            Toast.makeText(this,"Debe ingresar una marca",Toast.LENGTH_SHORT).show();

        }else{
        if(color.equals("Otro")) {
            if (otroColor.isEmpty()) {
                Toast.makeText(this, "Debe ingresar un color.", Toast.LENGTH_SHORT).show();
            } else {
                color = otroColor;
            }
        }
        }
        Auto auto=new Auto(color,marca);
        listaDeAutos.agregarAuto(auto);
        finish();

    }

}