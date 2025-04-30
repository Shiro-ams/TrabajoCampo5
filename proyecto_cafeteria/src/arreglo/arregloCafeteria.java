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

   
  
}

