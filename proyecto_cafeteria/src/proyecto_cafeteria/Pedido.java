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
        double precio = 0.0;
        if (producto.toLowerCase().contains("cafe")) precio += 5.0;
        else if (producto.toLowerCase().contains("té")) precio += 2.0;

        if (tamaño != null) {
            switch (tamaño) {
                case "Grande": precio += 1.0; break;
                case "Mediano": precio += 0.5; break;
                case "Pequeño": break;
            }
        }

        return precio; 
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
   

