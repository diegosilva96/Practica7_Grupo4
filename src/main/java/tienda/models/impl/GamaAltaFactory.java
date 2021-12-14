package tienda.models.impl;

import tienda.models.*;
import tienda.models.interfaces.IProductoFactory;

public class GamaAltaFactory implements IProductoFactory {

    @Override
    public LineaProducto getLineaProducto() {
        
        return new LineaGamaAlta();
    }

    @Override
    public MantenimientoProducto getMantenimiento() {
        
        return new MantenimientoPremium();
    }

    
}