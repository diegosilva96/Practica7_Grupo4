package tienda.models.impl;

import tienda.models.interfaces.ICategoria;
import tienda.models.interfaces.IFamilia;

public class FamiliaLaptops implements IFamilia {
    
    protected ICategoria categoria;

    public FamiliaLaptops() {}

    public FamiliaLaptops( ICategoria categoria ) {

        this.categoria = categoria;
    }

    @Override
    public String getNombre() {

        String nombre = "LAPTOPS";
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
        lista = lista +"\n* disco duro";
        lista = lista +"\n* puertos";
        lista = lista +"\n* teclado";

        if (categoria != null)  
            lista = lista +categoria.getFunciones();

        return lista;
    }
}
