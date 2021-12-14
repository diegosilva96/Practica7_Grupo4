package tienda.models;

import java.util.List;
import tienda.models.impl.DetallePedidoDescendenteIterator;

import tienda.models.impl.DetallePedidoIterator;
import tienda.models.interfaces.IDescuento;
import tienda.models.interfaces.IDetallePedidoIterator;
import tienda.models.interfaces.IEstadoPedido;
import tienda.models.interfaces.IPedidoDetalle;
import tienda.models.interfaces.IDetallePedidoCollection;

public class Pedido implements IDetallePedidoCollection {
    private String id;
    private Double montoTotal;
    private String direccionEntrega;
    private String cliente;
    private List<IPedidoDetalle> detallePedido;
    private Cliente clienteObj;
    private Double descuento;
    private String estadoEntrega;

    private IEstadoPedido estadoPedido;

    public Pedido() {}

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public Double getDescuento() {
        return descuento;
    }

    public IEstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(IEstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Cliente getClienteObj() {
        return clienteObj;
    }

    public void setClienteObj(Cliente clienteObj) {
        this.clienteObj = clienteObj;
    }

    public Pedido(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<IPedidoDetalle> getDetallePedido() {
        //List<IOrderItem> ordersItems = new ArrayList<>();
        return detallePedido;
    }

    public void setDetallePedido(List<IPedidoDetalle> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public void asignaClientePedido(String cliente) {
       
        System.out.println("Cliente que quiere el pedido: " + cliente);
        this.setCliente(cliente);
    }

    public Double calcularMontoPedido(IDescuento descuento) {
        List<IPedidoDetalle> detallePedido = this.getDetallePedido();

        Double total = 0.0;

        for (IPedidoDetalle item : detallePedido) {
            total += item.getPrecio();
        }

        // Resta el descuento
        if (descuento != null) {
            this.descuento = descuento.getDescuento();
            total = total - this.descuento;
        }

        return total;
    }

    public void pagar(MetodoPago paymentMethod)   {

        System.out.println("Paying order ...");
        paymentMethod.pagarPedido(this);
    }

    public void procesar() {

        estadoPedido.procesar(this);
    }

    @Override
    public IDetallePedidoIterator iterator() {
        
        return new DetallePedidoIterator( detallePedido );
    }
    
    @Override
    public IDetallePedidoIterator iteratorDescendente() {
        return new DetallePedidoDescendenteIterator( detallePedido );
    }
}