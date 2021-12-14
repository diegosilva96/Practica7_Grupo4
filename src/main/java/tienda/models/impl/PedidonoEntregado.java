package tienda.models.impl;
import tienda.models.Pedido;
import tienda.models.interfaces.IEstadoPedido;

public class PedidonoEntregado implements IEstadoPedido  {
    private String id;

    public PedidonoEntregado()   {
    }
    @Override
    public void procesar(Pedido pedido) {
       
        System.out.println("El pedido: " + pedido.getId()+" no se pudo entregar");
        System.out.println("El cliente: " + pedido.getCliente() +" no recibió el pedido");
       
    }
    
}
