package Vista;

import DAO.AccesoBaseProliferacion;
import Modelo.Celula;
import Modelo.TablaBaseDatosAbstracto;
import Modelo.Tejido;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaBaseDatosSQLite extends javax.swing.JFrame implements TablaBaseDatosAbstracto {

    String sql = "";

    /**
     * Creates new form TablaBaseDatosSQLite
     */
    public TablaBaseDatosSQLite() {
    }

    public TablaBaseDatosSQLite(DefaultTableModel modelo, Rectangle r) {
        initComponents();
        tblTablaBaseDatos.setModel(modelo);
        setSize(r.getSize());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaBaseDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblTablaBaseDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTablaBaseDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaBaseDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTablaBaseDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTablaBaseDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaBaseDatosMouseClicked
        try {
            generarSql(evt);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_tblTablaBaseDatosMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblTablaBaseDatos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void generarSql(MouseEvent evt) throws Exception {
        int idTejido;
        String nombre;
        idTejido = (int) tblTablaBaseDatos.getValueAt(tblTablaBaseDatos.getSelectedRow(), 0);
        nombre = (String) tblTablaBaseDatos.getValueAt(tblTablaBaseDatos.getSelectedRow(), 1);

        sql = "select celula.idcelula "
                + "from celula,tejido "
                + "where celula.idtejido =tejido.idtejido and "
                + "tejido.idtejido= " + idTejido;

        DefaultTableModel modeloCelulas = (DefaultTableModel) AccesoBaseProliferacion.getAccesoDatos().ejecutar(sql);
        JTable tablaCelulas = new JTable();
        tablaCelulas.setModel(modeloCelulas);
        int idCelula, numCelPadre, numCelVecinas;

        Tejido tejido = new Tejido(idTejido, nombre);
        tejido.setTamMuestra(tablaCelulas.getRowCount());

        for (int i = 1; i < tablaCelulas.getRowCount(); i++) {
            idCelula = (int) tablaCelulas.getValueAt(i, 0) - (idTejido * 1000);
            sql = "select count(lado.idcelula) "
                    + "from celula,lado "
                    + "where celula.idcelula =lado.idcelula and "
                    + "celula.idcelula= " + tablaCelulas.getValueAt(i, 0);
            DefaultTableModel modeloPadre = (DefaultTableModel) AccesoBaseProliferacion.getAccesoDatos().ejecutar(sql);
            JTable tablaPadre = new JTable();
            tablaPadre.setModel(modeloPadre);
            numCelPadre = (int) tablaPadre.getValueAt(0, 0);
            sql = "select count(lado.idcelulavecino) "
                    + "from celula,lado "
                    + "where celula.idcelula =lado.idcelulavecino and "
                    + "celula.idcelula= " + tablaCelulas.getValueAt(i, 0);
            DefaultTableModel modeloVecino = (DefaultTableModel) AccesoBaseProliferacion.getAccesoDatos().ejecutar(sql);
            JTable tablaVecino = new JTable();
            tablaVecino.setModel(modeloVecino);
            numCelVecinas = (int) tablaVecino.getValueAt(0, 0);
            int total = numCelPadre + numCelVecinas;
            tejido.getTejidoG().AgregarVertice(new Celula(idCelula, 0, total), idCelula);
        }

        sql = "select celula.idcelula, lado.idcelulavecino "
                + "from celula, lado, tejido "
                + "where celula.idtejido = tejido.idtejido and "
                + "tejido.idtejido = " + idTejido + " and "
                + "celula.idcelula = lado.idcelula";

        DefaultTableModel modeloArcos = (DefaultTableModel) AccesoBaseProliferacion.getAccesoDatos().ejecutar(sql);
        JTable tablaArcos = new JTable();
        tablaArcos.setModel(modeloArcos);

        for (int j = 0; j < tablaArcos.getRowCount(); j++) {
            int idCelVi, idCelVj;
            idCelVi = (int) tablaArcos.getValueAt(j, 0) - (idTejido * 1000);
            idCelVj = (int) tablaArcos.getValueAt(j, 1) - (idTejido * 1000);
            tejido.getTejidoG().AgregarArco(idCelVi, idCelVj, 0);
        }
    }
}
