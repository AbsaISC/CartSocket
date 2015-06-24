/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Ticket implements Serializable {
    private ArrayList<Producto> productos;
    private ArrayList<Item> cart;

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }
    
    public String genTicket(){
        return null;
    }
    
}
