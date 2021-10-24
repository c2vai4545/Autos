package cl.inacap.autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cl.inacap.autos.modelo.Auto;
import cl.inacap.autos.modelo.ListaDeAutos;

public class DetallesActivity extends AppCompatActivity {

    public Auto auto;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        intent = getIntent();
        int id=(Integer) intent.getExtras().get("idAuto");
        auto= ListaDeAutos.getInstancia().getAuto(id);

        TextView txtMarca=(TextView) findViewById(R.id.txtMarca);
        txtMarca.setText(auto.getMarca());

        TextView txtColor=(TextView) findViewById(R.id.txtColor);
        txtColor.setText(auto.getMarca()+" "+auto.getColor());

        TextView txtEstado=(TextView) findViewById(R.id.txtEstado);
        Button cambiar=(Button) findViewById(R.id.estado);

        if(auto.isEstado()==auto.disponible){
            txtEstado.setText("Disponible");
            cambiar.setText("Marcar como no disponible");
        }
        else {
            txtEstado.setText("No disponible");
            cambiar.setText("Marcar como disponible");

        }
    }

    public void cambiarEstado(View view){
        auto.setEstado(!auto.isEstado());
        setResult(RESULT_OK,intent);
        finish();
    }

}