package tienda.models;

import tienda.models.interfaces.IDescuento;

public class DescuentoAniversario implements IDescuento {

    private Double descuento;

    public DescuentoAniversario() {

        this.descuento = 100.0;
    }

    public Double getDescuento() {
        
        return this.descuento;
    }
}
