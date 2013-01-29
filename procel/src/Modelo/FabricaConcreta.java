/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.PanelDibujo;
import Vista.ShellSQLITE;
import Vista.TablaBaseDatosSQLite;
import Vista.GraficoBarras;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author waruano
 */
public class FabricaConcreta implements FabricaAbstracta{
    
    public FabricaConcreta(){}

    @Override
    public PanelDibujo nuevoPanelDibujo( final Graphics g, final Rectangle r, Tejido tejido) {
        return new PanelDibujo(g,r,tejido);
    }

    @Override
    public ShellSQLITE nuevoShell() {
        return new ShellSQLITE();
    }

    @Override
    public TablaBaseDatosSQLite nuevoTablaBaseDatos(DefaultTableModel modelo, Rectangle r) {
        return new TablaBaseDatosSQLite(modelo,r);
    }

    @Override
    public GraficoBarras nuevoEstadistica(Tejido tejido) {
        if (tejido != null) {
            return new GraficoBarras(tejido);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No hay un tejido abierto.");
            return null;
        }
        
    }
    
}
