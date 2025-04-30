package proyecto_cafeteria;

public class Pedido {
    private String producto;
    private String tamaño;
    private String extra;

    public Pedido(String producto, String tamaño) {
        this.producto = producto;
        this.tamaño = tamaño;
    }

    public Pedido(String producto, String tamaño, String extra) {
        this(producto, tamaño);
        this.extra = extra;
    }

    public double calcularPrecio() {
       
    }

    public double calcularPrecio(boolean incluirExtras) {
        double precio = calcularPrecio();
        if (incluirExtras && extra != null && !extra.isEmpty()) {
            precio += 0.75;
        }
        return precio;
    }
public String getProducto() {
        return producto;
    }

    public String getTamaño() {
        return tamaño;
    }

    public String getExtra() {
        return extra;
    }
}
   

