package cl.inacap.autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cl.inacap.autos.modelo.ListaDeAutos;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verLista(View view){
        Intent intent = new Intent(this, ListaDeAutos.class);
        startActivity(intent);
    }
    public void ingresarNuevo(View view){
        Intent intent=new Intent(this,NuevoAutoActivity.class);
        startActivity(intent);
    }
}