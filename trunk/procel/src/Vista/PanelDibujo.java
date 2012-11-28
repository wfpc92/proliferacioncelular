/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import LogicaNegocio.Arco;
import LogicaNegocio.Grafo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.JTextField;

/**
 *
 * @author JHONATAN
 */
public class PanelDibujo extends javax.swing.JFrame {

    int MAXCELULAS = 500;
    int x = 150;
    int y = 150;
    int ancho = 4;
    int alto = 4;
    public Vector<Integer> xvs;
    public Vector<Integer> yvs;
    public Vector<Grafo> vgrafos;
    int indice = 0;
    Random rnd = new Random(100);
    int max = 0;
    JTextField valor;

    Graphics g = null;
    Rectangle r = null;
    
    
    public PanelDibujo(final Graphics g, final Rectangle r) {
        initComponents();
        this.r = r;
        this.g = g;
        setSize(r.getSize());
        visualizar();
    }
    private void visualizar() {

        xvs = new Vector<Integer>();
        yvs = new Vector<Integer>();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);

        Grafo gr = new Grafo();
        gr.AgregarVertice(0, 0);
        gr.AgregarVertice(1, 1);
        gr.AgregarVertice(2, 2);
        gr.AgregarVertice(3, 3);
        gr.AgregarVertice(4, 4);
        gr.AgregarVertice(5, 5);
        gr.AgregarVertice(6, 6);
        gr.AgregarVertice(7, 7);
        gr.AgregarArco(0, 1, 0);
        gr.AgregarArco(0, 2, 0);
        gr.AgregarArco(0, 3, 0);
        gr.AgregarArco(0, 4, 0);
        gr.AgregarArco(0, 5, 0);
        gr.AgregarArco(1, 5, 0);
        gr.AgregarArco(1, 2, 0);
        gr.AgregarArco(1, 6, 0);
        gr.AgregarArco(2, 3, 0);
        gr.AgregarArco(2, 1, 0);
        gr.AgregarArco(3, 2, 0);
        gr.AgregarArco(3, 4, 0);
        gr.AgregarArco(3, 8, 0);

        int numeroVecinos = 0;
        numeroVecinos = averiguarVecinos(0, gr);
        //int xv = this.getWidth() / 2;
        //int yv = this.getHeight() / 2;
        int xv = this.r.width/ 2;
        int yv = this.r.height / 2;
        xvs.add(xv);
        yvs.add(yv);
        double radio = 40;
        float angulo = 360 / 15;
        for (int i = 1; i <= numeroVecinos; i++) {
            xv = (int) (xvs.get(0) + radio * Math.cos(i * angulo));
            yv = (int) (yvs.get(0) - radio * Math.sin(i * angulo));
            xvs.add(xv);
            yvs.add(yv);
        }
        int dibujados = 0;
        int sum = 0;
        for (int i = 0; i < numeroVecinos + 1; i++) {
            g.drawLine(xvs.get(0) + 2, yvs.get(0) + 2, xvs.get(i) + 2, yvs.get(i) + 2);
            g.setColor(Color.BLACK);
            g.fillOval(xvs.get(i), yvs.get(i), ancho, alto);
            g.setColor(Color.BLACK);
            g.drawOval(xvs.get(i), yvs.get(i), ancho, alto);
            g.setColor(Color.BLACK);
            g.drawString("" + i, xvs.get(i), yvs.get(i) + alto - 5);
            dibujados++;
        }

        int j = 1;
        while (j < 3) {
            int i = 0;
            int a = 0;
            numeroVecinos = averiguarVecinos(j, gr);
            int vecinosActuales = 0;
            vecinosActuales = averiguarActuales(j, gr);
            int vecinosGenerar = 0;
            vecinosGenerar = numeroVecinos - vecinosActuales;
            int m = 0;
            ArrayList<Arco> l = gr.getListaArcos();
            while (m < l.size()) {
                if (l.get(m).getVi() == j) {
                    if (l.get(m).getVj() < xvs.size()) {
                        g.drawLine(xvs.get(j) + 2, yvs.get(j) + 2, xvs.get(l.get(m).getVj()) + 2, yvs.get(l.get(m).getVj()) + 2);
                        g.setColor(Color.BLACK);
                    }
                }
                m++;
            }

            while (i < vecinosGenerar) {
                xv = (int) (xvs.get(j) + radio * Math.cos(a * angulo));
                yv = (int) (yvs.get(j) - radio * Math.sin(a * angulo));
                boolean valido;
                valido = evaluarPunto(j, xv, yv, radio);
                // System.out.println("al");
                if (valido) {
                    //System.out.println("Dib");
                    xvs.add(xv);
                    yvs.add(yv);
                    i++;
                }
                a++;
            }
            int k;
            //System.out.println(xvs.size());
            //System.out.println(dibujados);
            int it = 0;
            for (k = dibujados; k < xvs.size(); k++) {
                g.drawLine(xvs.get(j) + 2, yvs.get(j) + 2, xvs.get(k) + 2, yvs.get(k) + 2);
                g.setColor(Color.BLACK);
                g.fillOval(xvs.get(k), yvs.get(k), ancho, alto);
                g.setColor(Color.BLACK);
                g.drawOval(xvs.get(k), yvs.get(k), ancho, alto);
                g.setColor(Color.BLACK);
                // g.drawString(""+k, xvs.get(k), yvs.get(k)+alto-5);
                it++;

            }
            dibujados = dibujados + it;
            j++;
        }



    }

    int averiguarVecinos(int vert, Grafo gr) {
        int contador = 0;
        ArrayList<Arco> l = gr.getListaArcos();
        int j = 0;
        while (j < l.size()) {
            if (l.get(j).getVi() == vert || l.get(j).getVj() == vert) {
                contador++;
                //System.out.println(l.get(j).getVi()+"\t"+ l.get(j).getVj());
            }
            j++;
        }

        //System.out.println("Otro"+contador);
        return contador;
    }

    boolean evaluarPunto(int j, int xv, int yv, double radio) {
        for (int k = 0; k < j; k++) {
            double x, y, distancia;
            x = xvs.get(k);
            y = yvs.get(k);
            double restax = xv - x;
            double restay = yv - y;
            double cuadx = Math.pow(restax, 2);
            double cuady = Math.pow(restay, 2);
            double sumacuad = cuadx + cuady;
            distancia = Math.sqrt(sumacuad);
            if (distancia < radio) {
                return false;
            }
        }
        return true;
    }

    int averiguarActuales(int j, Grafo gr) {
        int k = 0, contador = 0;
        ArrayList<Arco> l = gr.getListaArcos();
        while (k < l.size()) {
            if (l.get(k).getVi() == j) {
                if (l.get(k).getVj() < xvs.size()) {
                    contador++;
                }
            }
            if (l.get(k).getVj() == j) {
                if (l.get(k).getVi() < j) {
                    contador++;
                }
            }
            k++;
        }
        System.out.println(contador);
        return contador;
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

        jButton1.setText("Agregar nodo");
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
                .addGap(0, 369, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 287, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        visualizar();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
