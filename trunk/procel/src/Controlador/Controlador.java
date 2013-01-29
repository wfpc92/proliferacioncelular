
package Controlador;

import Abstracto.Observado;
import Abstracto.Observador;
import Abstracto.Vista;
import DAO.AccesoBaseProliferacion;
import Modelo.Celula;
import Modelo.FabricaAbstracta;
import Modelo.FabricaConcreta;
import Vista.PanelDibujo;
import Vista.ShellSQLITE;
import Vista.TablaBaseDatosSQLite;
import Modelo.Tejido;
import Vista.GraficoBarras;
import Vista.ProliferacionCelular;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador implements Observador{

    private Vista principal;
    private Tejido<Celula> tejido;
    private FabricaAbstracta fabrica;
    
    public Controlador(Vista principal){
        this.principal = principal;
        fabrica = new FabricaConcreta();
    }
    
    @Override
    public void update(Observado o) {
       
    }

    public void nuevoTejido() {
        
        JFrame simulacionTejido;
        tejido = new Tejido(Math.abs(((int) System.nanoTime() % 34678)), "");
        tejido.fijarPoblacion();
        tejido.triangularizacion();
        simulacionTejido = (JFrame)fabrica.nuevoPanelDibujo(
                ((ProliferacionCelular)principal).getPnlPrincipal().getGraphics(), 
                ((ProliferacionCelular)principal).getPnlPrincipal().getBounds(), 
                tejido);
        ((ProliferacionCelular)principal).establecerPanel(simulacionTejido.getContentPane());
    }

    public void guardarTejido() {
        if (tejido != null) {
            tejido.fijarNombre();
            AccesoBaseProliferacion.getAccesoDatos().guardarTejido(tejido);
        } 
        else {
            JOptionPane.showMessageDialog(new JFrame(), "Abra primero un Tejido.");
        }
    }

    public void salir() {
        principal.termina();
    }

    public void graficaEstadistica() {
        if(fabrica != null)
            fabrica.nuevoEstadistica(tejido);
    }
    
    public void mostrarTabla(DefaultTableModel modelo) {
        JFrame tabla = (JFrame)fabrica.nuevoTablaBaseDatos(modelo, ((ProliferacionCelular)principal).getPnlPrincipal().getBounds());
        ((ProliferacionCelular)principal).establecerPanel(tabla.getContentPane());
    }

    public void iniciarShell() {
        JFrame shell = (JFrame)fabrica.nuevoShell();
        ((ProliferacionCelular)principal).establecerPanel(shell.getContentPane());
    }
    
    public void abrirTejido() {
        //aqui se abre el tejido, no esta implementado.
    }
    
    public void mostrarMensajeEsteril(){
         JOptionPane.showMessageDialog(new JFrame(), "La division ha sido realizada");
    }
    
    public void mostrarMensajeStrategy2(){
        JOptionPane.showMessageDialog(new JFrame(), "Esta funcionalidad no esta disponible");
    }
    
     public void mostrarMensajeStrategy3(){
        JOptionPane.showMessageDialog(new JFrame(), "Esta funcionalidad no esta disponible");
    }
}
