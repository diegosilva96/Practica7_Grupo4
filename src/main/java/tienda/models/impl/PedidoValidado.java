package tienda.models.impl;

import tienda.models.Pedido;
import tienda.models.interfaces.IEstadoPedido;

public class PedidoValidado implements IEstadoPedido    {

    private String id;

    public PedidoValidado() {}

    @Override
    public void procesar(Pedido pedido) {
    
        System.out.println("Pedido Validado con dirección de entrega: " + pedido.getDireccionEntrega());  
        pedido.setEstadoPedido( new PedidoPorEntregar());
        //pedido.procesar();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
