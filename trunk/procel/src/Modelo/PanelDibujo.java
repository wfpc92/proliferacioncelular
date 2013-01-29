package Modelo;

import Abstracto.Vista;
import Modelo.Arco;
import Modelo.Grafo;
import Modelo.Tejido;
import Modelo.Vertice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.JTextField;

public class PanelDibujo extends javax.swing.JFrame implements PanelDibujoAbstracto{

    int MAXCELULAS = 50;
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
    Tejido tejido = null;

    public PanelDibujo(final Graphics g, final Rectangle r, Tejido tejido) {
        initComponents();
        getContentPane().setBackground(Color.MAGENTA);
        this.r = r;
        this.g = g;
        this.tejido = tejido;
        setSize(r.getSize());
        visualizar();
    }
    
    @Override
    public void visualizar() {
        //getContentPane().setBackground(Color.MAGENTA);

        xvs = new Vector<Integer>();
        yvs = new Vector<Integer>();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);

        Grafo gr = new Grafo();



        Grafo grafoTriang = tejido.getTejidoG();


        ArrayList<Arco> listaArcos = new ArrayList<Arco>();
        listaArcos = grafoTriang.getListaArcos();     //aqui tengo los arcos desde el grafo 

        ArrayList<Vertice> listaVertice = new ArrayList<Vertice>();
        listaVertice = grafoTriang.getLista_vertices();

        for (int i = 0; i < listaVertice.size(); i++) {
            gr.AgregarVertice(listaVertice.get(i).getInfo(), listaVertice.get(i).getSubindice());
        }
        for (int i = 0; i < listaArcos.size(); i++) {
            gr.AgregarArco(listaArcos.get(i).getVerticeInicial(), listaArcos.get(i).getVerticeFinal(), 0);
        }


        int numeroVecinos = 0;
        //se puede evitar esta funcion con el numero de lados de la
        numeroVecinos = averiguarVecinos(0, gr);
        int xv = this.r.width / 2;
        int yv = this.r.height / 2;
        xvs.add(xv);
        yvs.add(yv);
        double radio = 60;
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

            // g.setColor(Color.green);
            dibujados++;
        }
        int j = 1;
        angulo = 180;
        radio = 40;

        if (j == 4) {
            radio = 100;
        }
        if (j == 5) {
            radio = 150;
            angulo = 25;
        }
        if (j == 7) {
            angulo = 43;
        }
        if (j == 12) {
            radio = 93;
            angulo = 90;
        }
        while (j < 50) { //Cambiar tamaño  xvs.size()
            angulo = 100;
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
                if (l.get(m).getVerticeInicial() == j) {
                    if (l.get(m).getVerticeFinal() < xvs.size()) {
                        //System.out.println("Vi: "+l.get(m).getVerticeInicial()+" Vj: "+l.get(m).getVerticeFinal());
                        g.drawLine((int) (xvs.get(j) + 2),
                                (int) (yvs.get(j) + 2),
                                (int) (xvs.get((int) l.get(m).getVerticeFinal()) + 2),
                                (int) (yvs.get((int) l.get(m).getVerticeFinal()) + 2));
                        getContentPane().setBackground(Color.white);
                        //g.setColor(Color.green);
                    }
                }
                m++;
            }
            double aux = radio;
            ArrayList<Integer> auxX = new ArrayList<Integer>();
            ArrayList<Integer> auxY = new ArrayList<Integer>();
            /*Collections.sort(auxX);
             Collections.sort(auxY);
             for(int k=0;k<auxX.size();k++){
             xvs.add(auxX.get(k));
             yvs.add(auxY.get(k));
             }*/
            while (i < vecinosGenerar) {
                xv = (int) (xvs.get(j) + aux * Math.cos(a * angulo));
                yv = (int) (yvs.get(j) - aux * Math.sin(a * angulo));
                boolean valido;
                valido = evaluarPunto(j, xv, yv, radio);
                if (i % 10 == 0) {
                    aux = aux + 5;
                }
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
                // System.out.println("Vi: "+j+" Vj: "+k);
                g.drawLine(xvs.get(j) + 2, yvs.get(j) + 2, xvs.get(k) + 2, yvs.get(k) + 2);
                g.setColor(Color.BLACK);
                g.fillOval(xvs.get(k), yvs.get(k), ancho, alto);
                g.setColor(Color.BLACK);
                g.drawOval(xvs.get(k), yvs.get(k), ancho, alto);
                g.setColor(Color.BLACK);
                g.drawString("" + k, xvs.get(k), yvs.get(k) + alto - 5);
                // g.setColor(Color.GREEN);
                it++;


            }
            dibujados = dibujados + it;
            j++;
            //System.out.println("este es j: "+j);
            this.revalidate();
            this.repaint();
        }
    }

    int averiguarVecinos(int vert, Grafo gr) {
        int contador = 0;
        ArrayList<Arco> l = gr.getListaArcos();
        int j = 0;
        while (j < l.size()) {
            if (l.get(j).getVerticeInicial() == vert || l.get(j).getVerticeFinal() == vert) {
                contador++;
            }
            j++;
        }
        return contador;
    }
    

    //quitar este metodo
    boolean evaluarPunto(int j, int xv, int yv, double radio) {

        //System.out.println("punto que se intenta ubicar: "+xv+" , "+yv+" j: "+j);
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
            if (distancia < (radio + 10)) {
                return false;
            }
        }

        return true;
    }

    int averiguarActuales(int j, Grafo gr) {
        int k = 0, contador = 0;

        ArrayList<Arco> l = gr.getListaArcos();
        while (k < l.size()) {
            if (l.get(k).getVerticeInicial() == j) {
                if (l.get(k).getVerticeFinal() < xvs.size()) {
                    contador++;
                }
            }
            if (l.get(k).getVerticeFinal() == j) {
                if (l.get(k).getVerticeInicial() < j) {
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
        //getContentPane().setBackground(Color.MAGENTA);
        visualizar();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
