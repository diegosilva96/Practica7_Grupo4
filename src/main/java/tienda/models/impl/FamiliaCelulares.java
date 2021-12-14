package tienda.models.impl;

import tienda.models.interfaces.ICategoria;
import tienda.models.interfaces.IFamilia;

public class FamiliaCelulares implements IFamilia   {

    protected ICategoria categoria;

    public FamiliaCelulares()   {}

    public FamiliaCelulares( ICategoria categoria ) {

        this.categoria = categoria;
    }

    @Override
    public String getNombre() {

        String nombre = "CELULARES";
        if (categoria != null)  
            nombre = nombre + " PARA " + categoria.getNombre();
        return nombre;
    }

    @Override
    public String getEspecificaciones() {

        String lista = new String();
        lista = "\nEspecificaciones:";
        lista = lista +"\n* memoria";
        lista = lista +"\n* procesador";
        lista = lista +"\n* redes";
        lista = lista +"\n* GPS";
        lista = lista +"\n* sensores";
    
        if (categoria != null)  
            lista = lista + categoria.getFunciones();

        return lista;
    }
    
}
