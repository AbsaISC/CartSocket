package Servidor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.JPanel;

public class ImageBackground extends JPanel {

   File file = null;
   JPanel jpanel;
//    public static BufferedImage img;
   private Image img;
//    public ImageBackground(File file) {
//        super();
//       this.file=file;
//    }

    public ImageBackground(Image img,JPanel jpanel) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(jpanel), img.getHeight(jpanel));
        this.jpanel=jpanel;
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0,jpanel.getWidth(),jpanel.getHeight(), null);
    }
}
