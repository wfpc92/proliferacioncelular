/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procel;

import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ingesis
 */
public class DibujadorCelula extends JPanel {
    Celula celula = null;
    
    public DibujadorCelula (Celula c){
        super();
        celula = c;
    }
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        
        Polygon poligono = new Polygon();
        int npoints = 0;
        npoints = asignarPuntos();
        
        for (int i = 0; i < npoints; i++)
            poligono.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / npoints)),
                                (int) (100 + 50 * Math.sin(i * 2 * Math.PI / npoints)));
        
        g.drawPolygon(poligono);
    }
    
    private int asignarPuntos() {
        return celula.getNumLado();
    }

    
}
