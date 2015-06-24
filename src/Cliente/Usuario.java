/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Producto.ImageRenderer;
import Producto.Item;
import Producto.Producto;
import Servidor.Store;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author absalom
 */
public class Usuario extends javax.swing.JFrame {

    String ip = null;
    int puerto = 9090;
    ArrayList<Producto> productos;
    ArrayList<Item> cart;

    /**
     * Creates new form Usuario
     */
    public Usuario() {
        initComponents();
        cart = new ArrayList<Item>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Conectar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tienda");

        jButton2.setText("Carrito");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Imagen", "Producto", "Descripción", "Precio", "Disponibles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Quitar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("comprar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(44, 44, 44)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(29, 29, 29)
                        .addComponent(jButton3)
                        .addGap(17, 17, 17)))
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(ip==null){
            pideip();
        }

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    obtenerServicio();
                } catch (IOException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        t.start();
//        updateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        addCart(obtenId());
        for (Item ito : cart) {
            System.out.println("obj: " + ito.getObjeto() + " cant:" + ito.getCantidad());
        }
        System.out.println("\n\n\n\n");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        subsCart(obtenId());
        for (Item ito : cart) {
            System.out.println("obj: " + ito.getObjeto() + " cant:" + ito.getCantidad());
        }
        System.out.println("\n\n\n\n");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(ip==null){
            pideip();
        }
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    doCompra();
                } catch (IOException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        t.start();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Carrito carto=new Carrito(productos,this.cart);
       carto.setVisible(true);
       
       
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    boolean isconnected = true;
    String str = "";

    private void obtenerServicio() throws IOException, ClassNotFoundException {
        Socket cl = new Socket(ip, puerto);
        System.out.println("Cliente conectado..\n transfiriendo archivo..");
        ObjectOutputStream ous = new ObjectOutputStream(cl.getOutputStream());
        ous.writeObject("get");
        ous.flush();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
        productos = (ArrayList<Producto>) ois.readObject();
        updateTable();
        ous.close();
        ois.close();
        cl.close();
    }

    private void doCompra() throws IOException, ClassNotFoundException {
        Socket cl = new Socket(ip, puerto);
        System.out.println("Cliente conectado..\n transfiriendo archivo..");
        ObjectOutputStream ous = new ObjectOutputStream(cl.getOutputStream());
        ous.writeObject("buy");
        ous.flush();
        ous.writeObject(cart);
        ous.flush();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
        productos = (ArrayList<Producto>) ois.readObject();
        updateTable();
        ous.close();
        ois.close();
        cl.close();
        cart = new ArrayList<Item>();
    }

    private int obtenId() {
        int row = jTable1.getSelectedRow();
        DefaultTableModel tmodel = (DefaultTableModel) (jTable1.getModel());
        return Integer.valueOf(tmodel.getValueAt(row, 0).toString());
    }

    private void addCart(int obtenId) {
        if (cart.isEmpty()) {
            int cant=findProdbyID(obtenId);
            if(productos.get(cant).getExistencia()<=0){
                JOptionPane.showConfirmDialog(this, "No existen productos");
            }
            cart.add(new Item().setObjeto(obtenId).setCantidad(1));
            return;
        }
        if (!isThereSum(obtenId)) {
            cart.add(new Item().setObjeto(obtenId).setCantidad(1));
        }
    }

    private void subsCart(int id) {
        int y = 0;
        int n;
        for (y = 0; y < cart.size(); y++) {
            if (cart.get(y).getObjeto() == id) {
                n = cart.get(y).resta();
                if (n <= 0) {
                    cart.remove(y);
                }
            }
            y++;
        }
    }

    public boolean isThereSum(int id) {
        int index = findProdbyID(id);
        for (Item it : cart) {
            if (it.getObjeto() == id) {
                if (it.getCantidad() < productos.get(index).getExistencia()) {
                    it.suma();
                }else{
                    JOptionPane.showMessageDialog(this, "No hay más productos en existencia");
                }
                return true;
            }
        }
        return false;
    }

    public int findProdbyID(int id) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getIdproducto() == id) {
                return i;
            }
        }
        return -1;
    }

    private void updateTable() {
        if (productos == null) {
            return;
        }
        DefaultTableModel tmodel = (DefaultTableModel) (jTable1.getModel());
        if (tmodel.getRowCount() > 0) {
            tmodel.setRowCount(0);
        }
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
        jTable1.setRowHeight(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        for (Producto p : productos) {
            byte[] data = null;
            data = p.getImagen();
            ImageIcon img = new ImageIcon(data);
            java.awt.Image image = img.getImage();
            java.awt.Image scaledimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            javax.swing.ImageIcon icon = new javax.swing.ImageIcon(scaledimg);
            Object[] rowData = {p.getIdproducto(), icon.getImage(), p.getProducto(), p.getDescripcion(), p.getPrecio(), p.getExistencia()};
            tmodel.addRow(rowData);

        }
    }

    private void pideip() {
        ip = JOptionPane.showInputDialog(this, "Enter your message", "Messages", 2);

    }
}
