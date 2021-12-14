
package tienda.models.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import tienda.models.interfaces.IDetallePedidoIterator;
import tienda.models.interfaces.IPedidoDetalle;

public class DetallePedidoDescendenteIterator implements IDetallePedidoIterator {
    
    private List<IPedidoDetalle> detallePedido;
    protected int currentDetail = 0;
    
    public DetallePedidoDescendenteIterator(List<IPedidoDetalle> detallePedido)    {
        this.detallePedido = detallePedido;
    }
    
    @Override
    public boolean hasNext() {
        
        return (currentDetail < detallePedido.size() && detallePedido.get(currentDetail) != null);
    }

    @Override
    public IPedidoDetalle next() {
        List<IPedidoDetalle> list = ordenarDescendente();
        return list.get(currentDetail++);
    }
    
    private List<IPedidoDetalle> ordenarDescendente() {
        return detallePedido.stream().sorted(Comparator.comparing(IPedidoDetalle::getPrecio).reversed()).collect(Collectors.toList());
    }

}
