package tienda.models.impl;

import tienda.models.DescuentoAniversario;
import tienda.models.DescuentoCupon;
import tienda.models.interfaces.IDescuento;
import tienda.models.interfaces.IDescuentoFactory;

public class DescuentoFactory implements IDescuentoFactory  {
    
    public static final String DESCUENTO_CUPON = "Cupon";
    public static final String DESCUENTO_ANIVERSARIO = "Aniversario";

    public IDescuento crearDescuento(String tipoDescuento)   {

        if (tipoDescuento.equals(DESCUENTO_CUPON))  {

            return new DescuentoCupon();
        }
        if (tipoDescuento.equals(DESCUENTO_ANIVERSARIO))  {

            return new DescuentoAniversario();
        }        
        else {

            return null;
        }
    }
}