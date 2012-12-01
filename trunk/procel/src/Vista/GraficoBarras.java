/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Celula;
import Modelo.Tejido;
import Modelo.Vertice;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author JHONATAN
 */
public class GraficoBarras extends javax.swing.JFrame {

    private BufferedImage grafica = null;
    private final Graphics g;
    private final Rectangle r;
    private Tejido<Celula> tejido = null;
    private ArrayList<String[]> listaResultados = null;
    /**
     * Creates new form GraficoBarras
     */
    public GraficoBarras(Graphics g, Rectangle r, Tejido tejido) {
        initComponents();
        this.g = g;
        this.r = r;
        this.tejido = tejido;
        setSize(r.getSize());
    }

    public BufferedImage creaImagen() {
        DefaultCategoryDataset modelo = new DefaultCategoryDataset();
         // column keys...
        int[] numeroCelulas = new int[20];
        for(int i = 0; i < numeroCelulas.length; i++){
            numeroCelulas[i] = 0;
        }
        ArrayList<Vertice<Celula>> lista = tejido.getTejidoG().getLista_vertices();
        for(int i = 0; i < tejido.getTejidoG().getLista_vertices().size(); i++){
            numeroCelulas[lista.get(i).getInfo().getNumLado()]++;
            System.out.println(i+". "+lista.get(i).getInfo().getId()+" "+lista.get(i).getInfo().getNumLado());
        }
        
        listaResultados = new ArrayList<>();
        
        for(int i = 0; i < numeroCelulas.length; i++){
            if(numeroCelulas[i] != 0){
                String[] valores = new String[2];
                valores[0] = i+"";
                valores[1] = numeroCelulas[i]+"";
                listaResultados.add(valores);
                modelo.addValue(numeroCelulas[i], tejido.getNombre(), i + " lados");
            }
        }
        
        
        
        boolean legend = true;
        boolean tooltips = true;
        boolean urls = false;
        JFreeChart chart = ChartFactory.createBarChart(
                "Celulas por numero de lados",
                "Numero de Lados",
                "Cantidad de celulas",
                modelo,
                PlotOrientation.VERTICAL,
                legend,
                tooltips,
                urls);
        return chart.createBufferedImage(r.getSize().width-400, r.getSize().height-100);
    }

    public void paint(java.awt.Graphics g) {
        //super.paint(g);
        if (grafica == null) {
            grafica = this.creaImagen();
        }
        g.drawImage(grafica, 30, 30, null); 
        JLabel[] lbl = imprimirResultados();
            for(int i = 0; i < lbl.length; i++){
                g.drawString(lbl[i].getText(), 950, 30 + 20*i);
            }
    }
    
    public JLabel[] imprimirResultados(){
        JLabel[] lstLabel = new JLabel[listaResultados.size()];
        
        JPanel panel = ProliferacionCelular.getInstance().getPnlHerramientas();
        panel.setLayout(new FlowLayout( ));
        
        for(int i = 0; i < listaResultados.size(); i++){
            lstLabel[i] = new JLabel("Numero de celulas de "+listaResultados.get(i)[0] +" lados: "+listaResultados.get(i)[1]);
            panel.add(lstLabel[i]);
        }
        return lstLabel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("grafico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 515, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 371, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        paint(g);
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}