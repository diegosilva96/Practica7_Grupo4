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
        /*while (iterator.hasNext()) {
            IPedidoDetalle detalle = iterator.next();
           
                System.out.println("Detalle: " + detalle.getIdProduct() + " - " + detalle.getCantidad() + " - " + detalle.getPrecio()+ detalle.getTipo() );
            
        }*/
            
        recorrido(pedido,"Internet");
        recorrido(pedido,"Promocion");

        System.out.println("Pedido Finalizado.");
    }
    public void recorrido(Pedido pedido,String tipo){
        IDetallePedidoIterator iterator = pedido.iterator();
        System.out.println("Pedidos de tipo :"+tipo);
        while (iterator.hasNext()) {
            IPedidoDetalle detalle = iterator.next();
            if(detalle.getTipo().equals(tipo)) {
                System.out.println("Detalle: " + detalle.getIdProduct() + " - " + detalle.getCantidad() + " - " + detalle.getPrecio() );
             }
          }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
