package Producto;

import java.io.Serializable;

public class Item implements Serializable {

    private int objeto;
    private int cantidad;

    public int getObjeto() {
        return objeto;
    }

    public Item setObjeto(int objeto) {
        this.objeto = objeto;
        return this;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Item setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public int suma() {
        cantidad++;
        return cantidad;
    }

    public int resta() {
            cantidad--;
            return cantidad;
    }

}
