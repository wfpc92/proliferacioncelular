/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstracto;
import Modelo.EstadisticaAbstracta;
import Modelo.PanelDibujoAbstracto;
import Modelo.ShellAbstracto;
import Modelo.TablaBaseDatosAbstracto;
import Modelo.Tejido;
import Vista.GraficoBarras;
import Vista.PanelDibujo;
import Vista.ShellSQLITE;
import Vista.TablaBaseDatosSQLite;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author waruano
 */
public interface FabricaAbstracta {
    public abstract PanelDibujoAbstracto nuevoPanelDibujo(final Graphics g, final Rectangle r, Tejido tejido);
    public abstract ShellAbstracto nuevoShell();
    public abstract TablaBaseDatosAbstracto nuevoTablaBaseDatos(DefaultTableModel modelo, Rectangle r);
    public abstract EstadisticaAbstracta nuevoEstadistica(Tejido tejido);
}
