/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Abstracto.Observado;
import Abstracto.Observador;
import Abstracto.Vista;
import DAO.AccesoBaseProliferacion;
import Modelo.Celula;
import Modelo.PanelDibujo;
import Modelo.ShellSQLITE;
import Modelo.TablaBaseDatos;
import Modelo.Tejido;
import Vista.GraficoBarras;
import Vista.ProliferacionCelular;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador implements Observador{

    Vista principal;
    Tejido<Celula> tejido;
    
    public Controlador(Vista principal){
        this.principal = principal;
    }
    
    @Override
    public void update(Observado o) {
       Vista v = (Vista)o;
       v.mostrar();
    }

    public void nuevoTejido() {
        PanelDibujo simulacionTejido;
        tejido = new Tejido(Math.abs(((int) System.nanoTime() % 34678)), "");
        tejido.fijarPoblacion();
        tejido.triangularizacion();
        simulacionTejido = new PanelDibujo(
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
        GraficoBarras graficoBarras = new GraficoBarras(tejido);
        graficoBarras.alistar();
        if (this.tejido != null) {
            graficoBarras.arranca();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No hay un tejido abierto.");
        }
    }

    public void mostrarTabla(DefaultTableModel modelo) {
        TablaBaseDatos tabla = new TablaBaseDatos(modelo, ((ProliferacionCelular)principal).getPnlPrincipal().getBounds());
        ((ProliferacionCelular)principal).establecerPanel(tabla.getContentPane());
    }

    public void iniciarShell() {
        ShellSQLITE shell = new ShellSQLITE();
        ((ProliferacionCelular)principal).establecerPanel(shell.getContentPane());
    }

    public void abrirTejido() {
        //aqui se abre el tejido, no esta implementado.
    }
}
