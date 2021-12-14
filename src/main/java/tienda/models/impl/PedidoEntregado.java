package tienda.models.impl;
import tienda.models.Pedido;
import tienda.models.interfaces.IEstadoPedido;

public class PedidoEntregado implements IEstadoPedido  {
    private String id;

    public PedidoEntregado()  {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public void procesar(Pedido pedido) {

            System.out.println("El pedido con id: " + pedido.getId() + " ha sido entregado de manera exitosa");
           
            pedido.setEstadoPedido( new PedidoFinalizado() );
            //pedido.procesar();
        
    }
    
}
