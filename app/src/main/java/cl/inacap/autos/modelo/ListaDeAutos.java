package cl.inacap.autos.modelo;

import java.util.ArrayList;

public class ListaDeAutos {
    private static ListaDeAutos instancia =new ListaDeAutos();
    private ArrayList<Auto> listaDeAutos;

    private ListaDeAutos(){
        listaDeAutos=new ArrayList<>();
        //agregarAuto(new Auto("Verde","Audi"));

    }
    public static ListaDeAutos getInstancia(){
        return instancia;
    }
    public void agregarAuto(Auto auto){
        listaDeAutos.add(auto);
    }
    public Auto getAuto(int id){
        return listaDeAutos.get(id);
    }
    public ArrayList<Auto> getListaDeAutos(){
        return listaDeAutos;
    }

    public void eliminarNoDisponible(){
        for (int i=0; i<listaDeAutos.size();i++){
            if(!listaDeAutos.get(i).isEstado()==Auto.disponible){//no Esta Disponible
                listaDeAutos.remove(i);
                i--;
            }
        }
    }
}
