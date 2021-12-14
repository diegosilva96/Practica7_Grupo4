package tienda.models.impl;

import tienda.models.*;
import tienda.models.interfaces.IProductoFactory;

public class GamaBajaFactory implements IProductoFactory {

    @Override
    public LineaProducto getLineaProducto() {

        return new LineaGamaBaja();
    }

    @Override
    public MantenimientoProducto getMantenimiento() {

        return new MantenimientoEstandar();
    }
    
}