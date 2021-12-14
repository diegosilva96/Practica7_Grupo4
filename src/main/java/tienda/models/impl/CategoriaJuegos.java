package tienda.models.impl;

import tienda.models.interfaces.ICategoria;

public class CategoriaJuegos implements ICategoria {

    public  CategoriaJuegos()   {}

    @Override
    public String getNombre() {
        
        return "JUEGOS";
    }

    @Override
    public String getFunciones() {
        
        String lista = new String();
        lista = "\nFunciones:";
        lista = lista + "\n* incluye sistema de refrigeramiento";
        lista = lista + "\n* graficos potentes";
        lista = lista + "\n* almacenamiento especial juegos";
        return lista;
    }    
}
