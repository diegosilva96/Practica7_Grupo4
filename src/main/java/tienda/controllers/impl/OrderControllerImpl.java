package tienda.controllers.impl;

import tienda.config.Paths;
import tienda.controllers.OrderController;
import tienda.models.BancoMetodoPago;
import tienda.models.BlockChainMetodoPago;
import tienda.models.Cliente;
import tienda.models.Pedido;
import tienda.models.impl.DescuentoFactory;
import tienda.models.impl.PedidoCreado;
import tienda.models.impl.PedidoDetalleInternet;
import tienda.models.impl.PedidoDetallePromocion;
import tienda.models.interfaces.IDescuento;
import tienda.models.interfaces.IPedidoDetalle;
import tienda.repositories.ClienteRepositorio;
import tienda.repositories.PedidoRepositorio;
import tienda.models.interfaces.IDetallePedidoIterator;

import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;

import java.util.ArrayList;
import java.util.List;

//import org.bson.types.ObjectId;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;

public class OrderControllerImpl implements OrderController {
    private static final String ID = "id";

    private PedidoRepositorio orderRepository;
    private ClienteRepositorio customerRepository;

    public OrderControllerImpl(PedidoRepositorio orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderControllerImpl(PedidoRepositorio orderRepository, ClienteRepositorio custRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = custRepository;
        System.out.println(customerRepository);
    }

    public void create(Context context) {
        Pedido order = context.bodyAsClass(Pedido.class);

        List<IPedidoDetalle> items = new ArrayList<>();
        PedidoDetalleInternet oi1 = new PedidoDetalleInternet( "P01010034", 1, 400.90);
        PedidoDetallePromocion oi2 = new PedidoDetallePromocion( "P01010025", 1, 500.90);
        PedidoDetalleInternet oi3 = new PedidoDetalleInternet( "P01010110", 1, 80.90);
        PedidoDetalleInternet oi4 = new PedidoDetalleInternet( "P01010400", 1, 670.10);
        PedidoDetalleInternet oi5 = new PedidoDetalleInternet( "P01010401", 1, 100.90);
        PedidoDetallePromocion oi6 = new PedidoDetallePromocion( "P01010114", 1, 50.40);
        items.add(oi1);
        items.add(oi2);
        items.add(oi3);
        items.add(oi4);
        items.add(oi5);
        items.add(oi6);
        order.setDetallePedido(items);

        order.setEstadoPedido( new PedidoCreado() );
        
        
        order.procesar();
     
        /*Cliente cliObj = (Cliente)customerRepository.find("61b7dc6ec86c81fd0e74a38c");
        System.out.println(cliObj==null?"no hay objeto":cliObj);
        order.setClienteObj( cliObj );
        System.out.println( cliObj.imprimeDatosCliente() );*/

        orderRepository.create(order);
        //String idO = order.getId().toString(); 
        context.status(HttpStatus.CREATED_201)
                .header(HttpHeader.LOCATION.name(), Paths.formatPostLocation(order.getId().toString()));
        if(order.getEstadoEntrega().equals("Por entregar") ){
            order.procesar();
            order.procesar();
            order.procesar();
            order.procesar();
        }else if (order.getEstadoEntrega().equals("Anulado") ){
            order.procesar();
        }
           
            
       
       
        
        

    }

    public void find(Context context) {
        String id = context.pathParam(ID);
        Pedido order = orderRepository.find(id);

        if (order == null) {
            throw new NotFoundResponse(String.format("A order with id '%s' is not found", id));
        }

        context.json(order);

        /*Pedido order = context.bodyAsClass(Pedido.class);
        IDetallePedidoIterator iterator = order.iterator();
        List<IPedidoDetalle> items = new ArrayList<>();
        PedidoDetalleInternet oi1 = new PedidoDetalleInternet( "P01010034", 1, 400.90);
        PedidoDetallePromocion oi2 = new PedidoDetallePromocion( "P01010025", 1, 600.90);
        PedidoDetalleInternet oi3 = new PedidoDetalleInternet( "P01010034", 1, 400.90);
        PedidoDetallePromocion oi4 = new PedidoDetallePromocion( "P01010025", 1, 600.90);
        PedidoDetalleInternet oi5 = new PedidoDetalleInternet( "P01010034", 1, 400.90);
        PedidoDetallePromocion oi6 = new PedidoDetallePromocion( "P01010025", 1, 600.90);
        items.add(oi1);
        items.add(oi2);
        items.add(oi3);
        items.add(oi4);
        items.add(oi5);
        items.add(oi6);

        order.setDetallePedido(items);
        order.setEstadoPedido( new PedidoCreado() );
        order.procesar();
        /*Cliente cliObj = (Cliente)customerRepository.find("61b7dc6ec86c81fd0e74a38c");
        System.out.println(cliObj==null?"no hay objeto":cliObj);
        order.setClienteObj( cliObj );
        System.out.println( cliObj.imprimeDatosCliente() );
        while (iterator.hasNext()) {
            IPedidoDetalle detalle = iterator.next();
            System.out.println("Detalle: " + detalle.getIdProduct() + " - " + detalle.getCantidad() + " - " + detalle.getPrecio() );
        }*/

    }

    public void findAll(Context context) {
        context.json(orderRepository.findAll());
    }

    @Override
    public void delete(Context context) {
        orderRepository.delete(context.pathParam(ID));

    }


    @Override
    public void update(Context context) {
        Pedido order = context.bodyAsClass(Pedido.class);
        String id = context.pathParam(ID);

        if (order.getId() != null && !order.getId().toString().equals(id)) {
            throw new BadRequestResponse("Id update is not allowed");
        }

        orderRepository.update(order, id);

    }
}
