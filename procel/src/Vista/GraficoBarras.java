/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.Series;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.CategoryTableXYDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author JHONATAN
 */
public class GraficoBarras extends javax.swing.JFrame {

    private BufferedImage grafica = null;
    private final Graphics g;
    private final Rectangle r;

    /**
     * Creates new form GraficoBarras
     */
    public GraficoBarras(Graphics g, Rectangle r) {
        initComponents();
        this.g = g;
        this.r = r;
        setSize(r.getSize());
    }

    public BufferedImage creaImagen() {
        BufferedImage imagen = null;
        final String series1 = "First";
         final String series2 = "Second";
         final String series3 = "Third";

         // column keys...
         final String category1 = "Category 1";
         final String category2 = "Category 2";
         final String category3 = "Category 3";
         final String category4 = "Category 4";
         final String category5 = "Category 5";
        
         DefaultCategoryDataset modelo = new DefaultCategoryDataset();
         modelo.addValue(1.0, series1, category1);
         modelo.addValue(4.0, series1, category2);
         modelo.addValue(3.0, series1, category3);
         modelo.addValue(5.0, series1, category4);
         modelo.addValue(5.0, series1, category5);

         modelo.addValue(5.0, series2, category1);
         modelo.addValue(7.0, series2, category2);
         modelo.addValue(6.0, series2, category3);
         modelo.addValue(8.0, series2, category4);
         modelo.addValue(4.0, series2, category5);

         modelo.addValue(4.0, series3, category1);
         modelo.addValue(3.0, series3, category2);
         modelo.addValue(2.0, series3, category3);
         modelo.addValue(3.0, series3, category4);
         modelo.addValue(6.0, series3, category5);
                 
         
        boolean legend = true;
        boolean tooltips = true;
        boolean urls = false;
        JFreeChart chart = ChartFactory.createBarChart(
                "Titulo del grafico",
                "categoryAxisLabel",
                "valueAxisLabel",
                modelo,
                PlotOrientation.VERTICAL,
                legend,
                tooltips,
                urls);
                
       
        return chart.createBufferedImage(400, 400);
    }

    public void paint(java.awt.Graphics g) {
        //super.paint(g);
        if (grafica == null) {
            grafica = this.creaImagen();
        }
        g.drawImage(grafica, 30, 30, null);
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
                .addGap(0, 335, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 277, Short.MAX_VALUE))
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