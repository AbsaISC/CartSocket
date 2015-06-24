/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cartsocket;

import Cliente.Usuario;
import Servidor.Store;

/**
 *
 * @author absalom
 */
public class CartSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Store.main(args);
        Usuario.main(args);
    }
    
}
