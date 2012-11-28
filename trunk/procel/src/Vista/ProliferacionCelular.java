package Vista;

import DAO.AccesoBaseProliferacion;
import LogicaNegocio.Celula;
import LogicaNegocio.Tejido;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class ProliferacionCelular extends javax.swing.JFrame implements ActionListener{

    DibujadorCelula jPanel1;
    //integracion activa
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProliferacionCelular().setVisible(true);
            }
        });
    }
    
    
    /**
     * Creates new form ProliferacionCelular
     */
    public ProliferacionCelular() {
        super("Proliferacion Celular");
        setTemaSistemaOperativoActual();
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    private void limpiarPanelPrincipal(){
        pnlPrincipal.removeAll();
        pnlPrincipal.repaint();
    }
    
    private void limpiarPanelHerramientas(){
        pnlHerramientas.removeAll();
        pnlHerramientas.repaint();
    }
    
    public void mostrarTablaBaseDatos(DefaultTableModel modelo){
        limpiarPanelPrincipal();
        pnlPrincipal.add((new TablaBaseDatos(modelo)).getContentPane());
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
        PanelDibujo panelDibujo = new PanelDibujo(pnlPrincipal.getGraphics(), pnlPrincipal.getBounds());
        this.pnlPrincipal.add(panelDibujo.getContentPane());
    }

    private void triangularizacion() {
       limpiarPanelPrincipal();
    }
    
    private void graficaEstadistica() {
        limpiarPanelPrincipal();
        pnlPrincipal.add(new GraficoBarras(pnlPrincipal.getGraphics(), pnlPrincipal.getBounds()).getContentPane());
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
        pnlHerramientas = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        itemNuevoTejido = new javax.swing.JMenuItem();
        itemEditarTejido = new javax.swing.JMenuItem();
        itemGuardarTejido = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemCerrar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuVisualizacionTejido = new javax.swing.JMenuItem();
        menuTriangularizacion = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1304, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlHerramientasLayout = new javax.swing.GroupLayout(pnlHerramientas);
        pnlHerramientas.setLayout(pnlHerramientasLayout);
        pnlHerramientasLayout.setHorizontalGroup(
            pnlHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        pnlHerramientasLayout.setVerticalGroup(
            pnlHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jMenu3.setText("Archivo");

        itemNuevoTejido.setText("Nuevo tejido");
        itemNuevoTejido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoTejidoActionPerformed(evt);
            }
        });
        jMenu3.add(itemNuevoTejido);

        itemEditarTejido.setText("Editar tejido");
        itemEditarTejido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarTejidoActionPerformed(evt);
            }
        });
        jMenu3.add(itemEditarTejido);

        itemGuardarTejido.setText("Guardar tejido");
        itemGuardarTejido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarTejidoActionPerformed(evt);
            }
        });
        jMenu3.add(itemGuardarTejido);
        jMenu3.add(jSeparator1);

        itemCerrar.setText("Cerrar");
        itemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarActionPerformed(evt);
            }
        });
        jMenu3.add(itemCerrar);

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

        jMenu2.setText("Tareas en Progreso");

        menuVisualizacionTejido.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, 0));
        menuVisualizacionTejido.setText("Visualizacion Tejido");
        menuVisualizacionTejido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVisualizacionTejidoActionPerformed(evt);
            }
        });
        jMenu2.add(menuVisualizacionTejido);

        menuTriangularizacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, 0));
        menuTriangularizacion.setText("Triangularizacion");
        menuTriangularizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTriangularizacionActionPerformed(evt);
            }
        });
        jMenu2.add(menuTriangularizacion);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, 0));
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
                .addContainerGap()
                .addComponent(pnlHerramientas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        //verifica que no haya un tejido abierto y confirma si desea guardar 
        //luego lo cierra y sale del sistema.
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemNuevoTejidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoTejidoActionPerformed
        //aqui se llama al controlador para crear el nuevo tejido
        
    }//GEN-LAST:event_itemNuevoTejidoActionPerformed

    private void itemEditarTejidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarTejidoActionPerformed
        // aqui se carga un tejido y se muestra luego
    }//GEN-LAST:event_itemEditarTejidoActionPerformed

    private void itemGuardarTejidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarTejidoActionPerformed
        //aqui se guarda el tejido en la base de datos
    }//GEN-LAST:event_itemGuardarTejidoActionPerformed

    private void itemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarActionPerformed
        //se cierra y se pregunta si debe guardar o no un tejido abierto, solo
        //esta activo el menu si y solo si hay un tejido abierto
    }//GEN-LAST:event_itemCerrarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        mostrarTablaBaseDatos(AccesoBaseProliferacion.getAccesoDatos().seleccionarRegistro(new Tejido()));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        mostrarTablaBaseDatos(AccesoBaseProliferacion.getAccesoDatos().seleccionarRegistro(new Celula()));
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            mostrarTablaBaseDatos((DefaultTableModel)AccesoBaseProliferacion.getAccesoDatos().ejecutar("select * from lado"));
        } catch (SQLException ex) {
            Logger.getLogger(ProliferacionCelular.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        mostrarShell();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menuVisualizacionTejidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVisualizacionTejidoActionPerformed
        visualizarTejido();
    }//GEN-LAST:event_menuVisualizacionTejidoActionPerformed

    private void menuTriangularizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTriangularizacionActionPerformed
        triangularizacion();
    }//GEN-LAST:event_menuTriangularizacionActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        graficaEstadistica();
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //jPanel1.visualizar(this.getGraphics(), new Celula(23,4));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCerrar;
    private javax.swing.JMenuItem itemEditarTejido;
    private javax.swing.JMenuItem itemGuardarTejido;
    private javax.swing.JMenuItem itemNuevoTejido;
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
    private javax.swing.JMenuItem menuTriangularizacion;
    private javax.swing.JMenuItem menuVisualizacionTejido;
    private javax.swing.JPanel pnlHerramientas;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}