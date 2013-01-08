package Modelo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class JPanelConFondo extends JPanel {
    private BufferedImage imagen;
    private final String[] str;
    
    public JPanelConFondo(BufferedImage imagen, String [] str){
        this.imagen = imagen;
        this.str = str;
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(imagen, 0, 0,getWidth()-200, getHeight(),null); 
        for(int i = 0; i < str.length; i++){
                g.drawString(str[i], 950, 200 + 20*i);
            }
        setOpaque(false);
        super.paint(g);
    }
 
}
