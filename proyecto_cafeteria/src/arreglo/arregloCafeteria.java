package arreglo;

import java.util.ArrayList;
import proyecto_cafeteria.Pedido;

public class arregloCafeteria {
    private ArrayList<Pedido> pedi;

   
    public arregloCafeteria() {
        pedi = new ArrayList<Pedido>();
        adicionar(new Pedido("Café", "Grande", "Leche"));
        adicionar(new Pedido("Té", "Mediano", "Azucar"));
    }

   
    public void adicionar(Pedido x) {
        pedi.add(x);
    }

   
    public int tamaño() {
        return pedi.size();
    }

  
    public Pedido obtener(int x) {
        return pedi.get(x);
    }

  
    public double promedioTotal() {
        double suma = 0.0;
        for (int i = 0; i < tamaño(); i++) {
            suma += obtener(i).calcularPrecio(true);
        }
        return tamaño() > 0 ? suma / tamaño() : 0.0;
    }

   
    public Pedido buscarPorProducto(String nombre) {
        for (int i = 0; i < tamaño(); i++) {
            if (obtener(i).getProducto().equalsIgnoreCase(nombre)) {
                return obtener(i);
            }
        }
        return null;
    }
public String mostrar() {
        if (pedi.isEmpty()) return "No hay pedidos.";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamaño(); i++) {
            Pedido p = obtener(i);
            sb.append("Pedido ").append(i + 1).append(":\n");
            sb.append("Producto: ").append(p.getProducto()).append("\n");
            sb.append("Tamaño: ").append(p.getTamaño()).append("\n");
            if (p.getExtra() != null && !p.getExtra().isEmpty()) {
                sb.append("Extra: ").append(p.getExtra()).append("\n");
            }
            sb.append(String.format("Total: $%.2f", p.calcularPrecio(true))).append("\n\n");
        }
        return sb.toString();
    }
}
   
  
}

