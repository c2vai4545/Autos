package cl.inacap.autos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
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



        String marca= ""; //((EditText) findViewById(R.id.ingresarMarca)).getText().toString();
        String color=((Spinner)findViewById(R.id.ingresarColor)).getSelectedItem().toString();
        String otroColor=((EditText)findViewById(R.id.otroColor)).getText().toString();
        String otraMarca=((EditText) findViewById(R.id.rMarca)).getText().toString();


        RadioGroup rgMarca = (RadioGroup) findViewById(R.id.rgMarca);
        int idRg= rgMarca.getCheckedRadioButtonId();
        switch (idRg) {
            case R.id.rAudi:
                marca += "Audi";
                break;
            case R.id.rVw:
                marca +="VolksWagen";
                break;
            case R.id.rFord:
                marca+="Ford";
                break;
            case R.id.otra:

                    if ((otraMarca.isEmpty())) {

                        Toast.makeText(this, "Debe ingresar una marca.", Toast.LENGTH_SHORT).show();
                    }else {
                        marca += otraMarca;
                    }

                break;

            }
        if(color.equals("Otro")) {
            if (otroColor.isEmpty()) {

                Toast.makeText(this, "Debe ingresar un color.", Toast.LENGTH_SHORT).show();
                finish();

            } else {
                color += otroColor;

            }
        }

        Auto auto=new Auto(color,marca);
        listaDeAutos.agregarAuto(auto);
        finish();


        }


    }

