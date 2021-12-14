package tienda.models.impl;

import tienda.models.interfaces.ICategoria;

public class CategoriaTrabajo implements ICategoria {

    public CategoriaTrabajo()   {}

    @Override
    public String getNombre() {
        
        return "TRABAJO";
    }

    @Override
    public String getFunciones() {
        
        String lista = new String();
        lista = "\nFunciones:";
        lista = lista +"\n* larga duracion bateria";
        lista = lista +"\n* procesador de alto rendimiento";
        lista = lista +"\n* mayor memoria";
        return lista;
    }
    
}
