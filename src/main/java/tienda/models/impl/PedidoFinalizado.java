package tienda.models.impl;

import tienda.models.Pedido;
import tienda.models.interfaces.IDetallePedidoIterator;
import tienda.models.interfaces.IEstadoPedido;
import tienda.models.interfaces.IPedidoDetalle;

public class PedidoFinalizado implements IEstadoPedido {

    private String id;
    
    public PedidoFinalizado()   {}
    
    @Override
    public void procesar(Pedido pedido) {

        System.out.println("Finalizando pedido: " + pedido.getId());
        IDetallePedidoIterator iterator = pedido.iterator();
        while (iterator.hasNext()) {
            IPedidoDetalle detalle = iterator.next();
            System.out.println("Detalle: " + detalle.getIdProduct() + " - " + detalle.getCantidad() + " - " + detalle.getPrecio() );
        }

        System.out.println("Pedido Finalizado.");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
