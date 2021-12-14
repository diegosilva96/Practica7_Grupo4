package tienda.models.interfaces;

import tienda.models.LineaProducto;
import tienda.models.MantenimientoProducto;

public interface IProductoFactory {

    public LineaProducto getLineaProducto();

    public MantenimientoProducto getMantenimiento();

}