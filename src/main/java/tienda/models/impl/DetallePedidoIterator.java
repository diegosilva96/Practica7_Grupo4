package tienda.models.impl;

//import java.util.Iterator;
import java.util.List;

import tienda.models.interfaces.IDetallePedidoIterator;
import tienda.models.interfaces.IPedidoDetalle;

public class DetallePedidoIterator implements IDetallePedidoIterator {    // Iterator<IPedidoDetalle>

    private List<IPedidoDetalle> detallePedido;
    protected int currentDetail = 0;

    public DetallePedidoIterator(List<IPedidoDetalle> detallePedido)    {
        this.detallePedido = detallePedido;
    }

    @Override
    public boolean hasNext() {

        return (currentDetail < detallePedido.size() && detallePedido.get(currentDetail) != null);
    }

    @Override
    public IPedidoDetalle next() {

        return detallePedido.get(currentDetail++);
    }
    
}
