/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Modelo.Celula;
/**
 *
 * @author ingesis
 */
public class DibujadorCelula extends JPanel {
    Celula celula = null;
    
    public DibujadorCelula (){
        super();
    }
    public void visualizar(Graphics g, Celula c){
        super.paintComponent(g);
        celula = c;
        Polygon poligono = new Polygon();
        int npoints = 0;
        npoints = asignarPuntos();
        
        for (int i = 0; i < npoints; i++)
            poligono.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / npoints)),
                                (int) (100 + 50 * Math.sin(i * 2 * Math.PI / npoints)));
        
        g.drawPolygon(poligono);
        //g.fillPolygon(poligono); paa ponerle fondo
    }
    
    private int asignarPuntos() {
        return celula.getNumLado();
    }

    
}
