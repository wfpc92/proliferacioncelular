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
        gr.AgregarVertice(8, 8);
        gr.AgregarVertice(9, 9);
        gr.AgregarVertice(10, 10);
        gr.AgregarVertice(11, 11);
        gr.AgregarVertice(12, 12);
        gr.AgregarVertice(13, 13);
        gr.AgregarVertice(14, 14);
        gr.AgregarVertice(15, 15);
        gr.AgregarVertice(16, 16);
        gr.AgregarVertice(17, 17);
        gr.AgregarVertice(18, 18);
        gr.AgregarVertice(19, 19);
        gr.AgregarVertice(20, 20);
        gr.AgregarVertice(21, 21);
        gr.AgregarVertice(22, 22);
        gr.AgregarVertice(23, 23);
        gr.AgregarVertice(24, 24);
        gr.AgregarVertice(25, 25);
        gr.AgregarVertice(26, 26);
        
        gr.AgregarArco(0, 1, 0);
        gr.AgregarArco(0, 2, 0);
        gr.AgregarArco(0, 3, 0);
        gr.AgregarArco(0, 4, 0);
        gr.AgregarArco(0, 5, 0);
        gr.AgregarArco(1, 2, 0);
        gr.AgregarArco(2, 3, 0);
        gr.AgregarArco(3, 4, 0);
        gr.AgregarArco(4, 5, 0);
        gr.AgregarArco(1, 5, 0);
        gr.AgregarArco(1, 6, 0);
        gr.AgregarArco(1, 7, 0);
        gr.AgregarArco(2, 8,0);
        gr.AgregarArco(2, 9,0);
        gr.AgregarArco(2, 10,0);
        gr.AgregarArco(2, 11,0);
        gr.AgregarArco(3, 12, 0);
        gr.AgregarArco(3, 13, 0);
        gr.AgregarArco(3, 14, 0);
        gr.AgregarArco(3, 15, 0);
        gr.AgregarArco(4, 16, 0);
        gr.AgregarArco(4, 17, 0);
        gr.AgregarArco(5, 18, 0);
        gr.AgregarArco(5, 19, 0);
        gr.AgregarArco(5, 20, 0);
        gr.AgregarArco(5, 21, 0);
        gr.AgregarArco(6, 7, 0);
        gr.AgregarArco(7, 8, 0);
        gr.AgregarArco(8, 9, 0);
        gr.AgregarArco(9, 10, 0);
        gr.AgregarArco(10, 11, 0);
        gr.AgregarArco(11, 12, 0);
        gr.AgregarArco(12, 13, 0);
        gr.AgregarArco(13, 14, 0);
          gr.AgregarArco(14, 15, 0);
        gr.AgregarArco(15, 16, 0);
         gr.AgregarArco(16, 17, 0);
        gr.AgregarArco(18, 19, 0);
         gr.AgregarArco(19, 20, 0);
        gr.AgregarArco(6, 22, 0);
         gr.AgregarArco(6, 23, 0);
        gr.AgregarArco(7, 24, 0);
         gr.AgregarArco(7, 25, 0);
        //gr.AgregarArco(18, 19, 0);
        
      

        int numeroVecinos = 0;
        numeroVecinos = averiguarVecinos(0, gr);
        int xv = this.r.width/ 2;
        int yv = this.r.height / 2;
        xvs.add(xv);
        yvs.add(yv);
        double radio =60;
        float angulo = 360/15;
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
        angulo=360/70;
        while (j < 19) { //Cambiar tamaño
            angulo=100;
            radio=60;
           if(j==4){
               radio=100;
                
            }
           if(j==5){
               //radio=90;
               angulo=360/30;
           }
    
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
                        g.drawLine((int)(xvs.get(j) + 2), 
                                (int)(yvs.get(j) + 2), 
                                (int)(xvs.get((int)l.get(m).getVj()) + 2),
                                (int)(yvs.get((int)l.get(m).getVj()) + 2));
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
                if (valido) {
                    xvs.add(xv);
                    yvs.add(yv);
                    i++;
                }
                a++;
            }
            int k;
            int it = 0;
            for (k = dibujados; k < xvs.size(); k++) {
                g.drawLine(xvs.get(j) + 2, yvs.get(j) + 2, xvs.get(k) + 2, yvs.get(k) + 2);
                g.setColor(Color.BLACK);
                g.fillOval(xvs.get(k), yvs.get(k), ancho, alto);
                g.setColor(Color.BLACK);
                g.drawOval(xvs.get(k), yvs.get(k), ancho, alto);
                g.setColor(Color.BLACK);
                g.drawString("" + k, xvs.get(k), yvs.get(k) + alto - 5);
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
            }
            j++;
        }
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
            if (distancia < (radio+10)) {
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
