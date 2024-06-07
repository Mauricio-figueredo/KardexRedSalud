package modelo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class Escritorio extends JDesktopPane{

    private BufferedImage img;

    public Escritorio() {
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/imagenes/fondo.jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
        @Override
    protected void paintComponent(Graphics ga){
        super.paintComponent(ga);
        ga.drawImage(img, 50, 50, 1000, 920, null);
    }

}
