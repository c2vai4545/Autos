package cl.inacap.autos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cl.inacap.autos.modelo.Auto;
import cl.inacap.autos.modelo.ListaDeAutos;

public class ListaDeAutosActivity extends ListActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargarLista();
    }

    public void cargarLista(){
        lista=getListView();
        List<Auto> autoList= ListaDeAutos.getInstancia().getListaDeAutos();

        ArrayAdapter<Auto> listaAdapter = new ArrayAdapter<Auto>(this,
                android.R.layout.simple_list_item_1,autoList);
        lista.setAdapter(listaAdapter);
    }


    @Override
    public void onListItemClick(ListView listView, View view, int posicion, long id){
        Intent intent=new Intent(ListaDeAutosActivity.this, DetallesActivity.class);
        intent.putExtra("idAuto", (int)id);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1){
            if(resultCode == RESULT_OK){
                cargarLista();
            }
        }
    }

}