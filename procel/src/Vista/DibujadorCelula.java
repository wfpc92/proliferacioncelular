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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ingesis
 */
public class DibujadorCelula extends JFrame {
    Celula celula = null;
    
    public DibujadorCelula (){
        super();
        setVisible(true);
        paint(getGraphics());
        setExtendedState(MAXIMIZED_BOTH);
        
    }
    
    
    
    @Override
    public void paint(Graphics g){
        celula = new Celula();
        Polygon poligono = new Polygon();
        int npoints = 0;
        npoints = asignarPuntos();
        
        for (int i = 0; i < npoints; i++){
            try {
                poligono.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / npoints)),
                                    (int) (100 + 50 * Math.sin(i * 2 * Math.PI / npoints)));
                Thread.sleep(3000);
            getGraphics().drawPolygon(poligono);
            }
            //g.fillPolygon(poligono); paa ponerle fondo
            catch (InterruptedException ex) {
                Logger.getLogger(DibujadorCelula.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        //g.fillPolygon(poligono); paa ponerle fondo
    }
    
    private int asignarPuntos() {
        return celula.getNumLado();
    }

    
}
