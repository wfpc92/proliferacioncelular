package Vista;

import Abstracto.Vista;
import DAO.AccesoBaseProliferacion;
import Modelo.Celula;
import Modelo.Tejido;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author equipo scrum
 */
public class ProliferacionCelular extends javax.swing.JFrame 
    implements ActionListener, Vista 
{

    Tejido<Celula> tejido =null;    
    private static ProliferacionCelular procel;

    private ProliferacionCelular() {
        super("Proliferacion Celular");
        setTemaSistemaOperativoActual();
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    /**
     *Retorna una unica instancia (SINGLETON).
     * Valida si la instancia de clase esta vacia, sino devuelve una
     * instancia no vacia.
     * 
     * @param  
     * @return Instancia de ProliferacionCelular
     */
    public static ProliferacionCelular getInstance() {
        if (procel == null) {
            procel = new ProliferacionCelular();
        }
        return procel;
    }

    /**
     *Limpia la pantalla Retorna una unica instancia (SINGLETON).
     * Valida si la instancia de clase esta vacia, sino devuelve una
     * instancia no vacia.
     * 
     * @param  
     * @return Instancia de ProliferacionCelular
     */
    
    private void limpiarPanelPrincipal() {
        pnlPrincipal.removeAll();
        pnlPrincipal.repaint();
    }

    public void mostrarTablaBaseDatos(DefaultTableModel modelo) {
        limpiarPanelPrincipal();
        pnlPrincipal.add((new TablaBaseDatos(modelo, pnlPrincipal.getBounds())).getContentPane());
    }

    private void setTemaSistemaOperativoActual() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProliferacionCelular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProliferacionCelular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProliferacionCelular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProliferacionCelular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    private void mostrarShell() {
        limpiarPanelPrincipal();
        ShellSQLITE vista = new ShellSQLITE();
        pnlPrincipal.add(vista.getContentPane());

    }

    private void visualizarTejido() {
        limpiarPanelPrincipal();
        PanelDibujo panelDibujo = new PanelDibujo(pnlPrincipal.getGraphics(), pnlPrincipal.getBounds(), tejido);
        ProliferacionCelular.pnlPrincipal.add(panelDibujo.getContentPane());
    }

    private void graficaEstadistica() {
        limpiarPanelPrincipal();
        if (tejido != null) {
            GraficoBarras graficoBarras = new GraficoBarras(tejido);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No hay un tejido abierto.");
        }
    }

    public void generarTejido(Tejido tejido) {
        limpiarPanelPrincipal();
        tejido.triangularizacion();
        this.pnlPrincipal.add(new PanelDibujo(pnlPrincipal.getGraphics(), pnlPrincipal.getBounds(), tejido).getContentPane());
    }

    private void abrirTejido() {
        limpiarPanelPrincipal();
        DefaultTableModel modelo = AccesoBaseProliferacion.getAccesoDatos().seleccionarRegistro(new Tejido());
        mostrarTablaBaseDatos(modelo);
    }

    private void guardarTejido() {
        if (tejido != null) {
            String nombre = JOptionPane.showInputDialog("Digite Nombre de Tejido");
            if (nombre == null || "".equals(nombre)) {
                //volver a preguntar
            } 
            else {
                tejido.setNombre(nombre);
                String sqlTejido = "insert into tejido values ("
                                   + "" + tejido.getId() + ","
                                   + "'" + tejido.getNombre() + "')";
                AccesoBaseProliferacion.getAccesoDatos().ejecutar(sqlTejido);
                  
                 for (int i = 0; i < tejido.getTejidoG().getLista_vertices().size(); i++) {
                    String sqlCelula="";
                    int idCelula;
                    idCelula=(tejido.getId()*1000)+i;
                    sqlCelula = "insert into celula(idcelula, idtejido) values("
                                + idCelula + ","+ tejido.getId() + ")";
                    AccesoBaseProliferacion.getAccesoDatos().ejecutar(sqlCelula);
                 }    
                    
                 for (int j = 0; j < tejido.getTejidoG().getListaArcos().size(); j++){
                     String sqlLado="";  
                     int idLado;
                     idLado=(tejido.getId()*1000)+j;
                     int idCelulaVecino;
                     idCelulaVecino = (int)((tejido.getId()*1000)+tejido.getTejidoG().getListaArcos().get(j).getVerticeFinal());
                     int idCelula;
                     idCelula=(int)((tejido.getId()*1000)+tejido.getTejidoG().getListaArcos().get(j).getVerticeInicial());
                     sqlLado = "insert into lado(idcelulavecino,idlado,longitud,idcelula)values("
                                + idCelulaVecino + ","+ idLado + "," + 0 + "," + idCelula + ")";
                     AccesoBaseProliferacion.getAccesoDatos().ejecutar(sqlLado);            
                 }  
            }
        } 
        else {
            JOptionPane.showMessageDialog(new JFrame(), "Abra primero un Tejido.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        itemNuevoTejido = new javax.swing.JMenuItem();
        itemGuardarTejido = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1507, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jMenu3.setText("Archivo");

        itemNuevoTejido.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itemNuevoTejido.setText("Nueva Poblacion");
        itemNuevoTejido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoTejidoActionPerformed(evt);
            }
        });
        jMenu3.add(itemNuevoTejido);

        itemGuardarTejido.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        itemGuardarTejido.setText("Guardar tejido");
        itemGuardarTejido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarTejidoActionPerformed(evt);
            }
        });
        jMenu3.add(itemGuardarTejido);
        jMenu3.add(jSeparator1);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        jMenu3.add(itemSalir);

        jMenuBar2.add(jMenu3);

        jMenu1.setText("Base de Datos");

        jMenuItem1.setText("Tabla Tejido");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Tabla Celula");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Tabla Vecinos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Shell");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar2.add(jMenu1);

        jMenu2.setText("Estadisticas");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Graficos de barras");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        //verifica que no haya un tejido abierto y confirma si desea guardar 
        //luego lo cierra y sale del sistema.
        System.exit(0);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemNuevoTejidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoTejidoActionPerformed
        //aqui se llama al controlador para crear el nuevo tejido
        tejido = new Tejido(Math.abs(((int) System.nanoTime() % 34678)), "", new Celula(0, 5, 5), 49);
        generarTejido(tejido);
    }//GEN-LAST:event_itemNuevoTejidoActionPerformed

    private void itemGuardarTejidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarTejidoActionPerformed
        //aqui se guarda el tejido en la base de datos
        guardarTejido();
    }//GEN-LAST:event_itemGuardarTejidoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        mostrarTablaBaseDatos(AccesoBaseProliferacion.getAccesoDatos().seleccionarRegistro(new Tejido()));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        mostrarTablaBaseDatos(AccesoBaseProliferacion.getAccesoDatos().seleccionarRegistro(new Celula()));
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       
            mostrarTablaBaseDatos((DefaultTableModel) AccesoBaseProliferacion.getAccesoDatos().ejecutar("select * from lado"));
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        mostrarShell();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        graficaEstadistica();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //jPanel1.visualizar(this.getGraphics(), new Celula(23,4));
    }
    

    public Dimension getTamanioPnlPrincipal() {
        return getPnlPrincipal().getBounds().getSize();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemGuardarTejido;
    public javax.swing.JMenuItem itemNuevoTejido;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private static javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables

   
    public JMenuItem getItemGuardarTejido() {
        return itemGuardarTejido;
    }

    public void setItemGuardarTejido(JMenuItem itemGuardarTejido) {
        this.itemGuardarTejido = itemGuardarTejido;
    }

    public JMenuItem getItemNuevoTejido() {
        return itemNuevoTejido;
    }

    public void setItemNuevoTejido(JMenuItem itemNuevoTejido) {
        this.itemNuevoTejido = itemNuevoTejido;
    }

    public JMenuItem getItemSalir() {
        return itemSalir;
    }

    public void setItemSalir(JMenuItem itemSalir) {
        this.itemSalir = itemSalir;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    public JMenu getjMenu2() {
        return jMenu2;
    }

    public void setjMenu2(JMenu jMenu2) {
        this.jMenu2 = jMenu2;
    }

    public JMenu getjMenu3() {
        return jMenu3;
    }

    public void setjMenu3(JMenu jMenu3) {
        this.jMenu3 = jMenu3;
    }

    public JMenuBar getjMenuBar2() {
        return jMenuBar2;
    }

    public void setjMenuBar2(JMenuBar jMenuBar2) {
        this.jMenuBar2 = jMenuBar2;
    }

    public JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    public void setjMenuItem1(JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }

    public JMenuItem getjMenuItem2() {
        return jMenuItem2;
    }

    public void setjMenuItem2(JMenuItem jMenuItem2) {
        this.jMenuItem2 = jMenuItem2;
    }

    public JMenuItem getjMenuItem3() {
        return jMenuItem3;
    }

    public void setjMenuItem3(JMenuItem jMenuItem3) {
        this.jMenuItem3 = jMenuItem3;
    }

    public JMenuItem getjMenuItem4() {
        return jMenuItem4;
    }

    public void setjMenuItem4(JMenuItem jMenuItem4) {
        this.jMenuItem4 = jMenuItem4;
    }

    public JMenuItem getjMenuItem5() {
        return jMenuItem5;
    }

    public void setjMenuItem5(JMenuItem jMenuItem5) {
        this.jMenuItem5 = jMenuItem5;
    }

    public Separator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(Separator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }
    public JPanel getPnlPrincipal() {
        return pnlPrincipal;
    }

    public void setPnlPrincipal(JPanel pnlPrincipal) {
        this.pnlPrincipal = pnlPrincipal;
    }

    public Graphics getGraficos() {
        return getGraphics();
    }

    Tejido getTejido() {
        return tejido;
    }

    @Override
    public void arranca() {
        this.setVisible(true);
    }

    @Override
    public void termina() {
        System.exit(0);
    }
}
