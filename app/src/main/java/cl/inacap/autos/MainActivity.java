package cl.inacap.autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import cl.inacap.autos.modelo.Auto;
import cl.inacap.autos.modelo.ListaDeAutos;

public class MainActivity extends AppCompatActivity {

    private ListaDeAutos lista=ListaDeAutos.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void verLista(View view){
        ArrayList<Auto> autos=lista.getListaDeAutos();
        if(autos.size()>0) {


            Intent intent = new Intent(this, ListaDeAutos.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"No hay Autos disponibles",Toast.LENGTH_SHORT).show();
        }
    }
    public void ingresarNuevo(View view){
        Intent intent=new Intent(this,NuevoAutoActivity.class);
        startActivity(intent);
    }
}