import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;

    public Carrito() {
        this.items = new ArrayList<ItemCarrito>();
    }

    public void agregarItem(ItemCarrito item) {
        this.items.add(item);
    }

    public void quitarItem(ItemCarrito item) {
        this.items.remove(item);
    }

    public Double total() throws Exception {
        double tot = 0;
        for (ItemCarrito item : this.items) {
            double precioItem = item.subtotal();
            tot += precioItem;
        }
        if(tot == 0 ){
            throw new Exception("Carrito con precio 0");

        }

//        Descuento desc = new DescuentoFijo();
//        desc.setValorDesc(200);
//        tot = desc.valorFinal(tot);

        return tot;
    }


}