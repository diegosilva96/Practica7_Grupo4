package tienda.models.impl;
import tienda.models.Pedido;
import tienda.models.interfaces.IEstadoPedido;

public class PedidoAnulado implements IEstadoPedido  {
    private String id;

    public PedidoAnulado()   {
    }
    @Override
    public void procesar(Pedido pedido) {
        System.out.println("El pedido ha sido anulado, se procede a cancelar el proceso");
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
