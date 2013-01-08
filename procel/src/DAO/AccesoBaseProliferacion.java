package DAO;

import Modelo.Celula;
import Modelo.Tejido;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AccesoBaseProliferacion {

    private static final String cadenaConexionDDBB = "jdbc:sqlite:mydatabase.sqlite";
    private static AccesoBaseProliferacion dao;
    private static Connection conn;
   
    //<editor-fold defaultstate="collapsed" desc=" DDL de la base de datos ">
    private static String crearCelula =
            "CREATE TABLE IF NOT EXISTS CELULA("
            + "IDCELULA INTEGER PRIMARY KEY, "
            + "IDTEJIDO INTEGER REFERENCES TEJIDO(IDTEJIDO))";
    private static String crearTejido =
            "CREATE TABLE IF NOT EXISTS TEJIDO("
            + "IDTEJIDO INTEGER PRIMARY KEY, "
            + "NOMBRE VARCHAR(15))";
    private static String crearLado =
            "CREATE TABLE IF NOT EXISTS LADO( "
            + "IDCELULAVECINO INTEGER NOT NULL, "
            + "IDLADO INTEGER NOT NULL, "
            + "LONGITUD FLOAT(4) NOT NULL, "
            + "IDCELULA INTEGER NULL, "
            + "CONSTRAINT PK_LADO PRIMARY KEY (IDLADO,IDCELULA), "
            + "CONSTRAINT FK_LADO_VECINO FOREIGN KEY (IDCELULAVECINO) REFERENCES CELULA(IDCELULA), "
            + "CONSTRAINT FK_LADO_CELULA FOREIGN KEY (IDCELULA) REFERENCES CELULA(IDCELULA))";
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Implementacion Patron Singleton ">
    /**
     * se crea una nueva instancia si dao no es nulo
     */
    private synchronized static void createInstance() {
        if (dao == null) {
            dao = new AccesoBaseProliferacion();
        }
    }
    /**
     * permite acceder una solo instancia a accesoBaseProliferacion.
     * @return retorna dao
     */
    public static AccesoBaseProliferacion getAccesoDatos() {
        createInstance();
        return dao;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructor Privado de Clase ">
    private AccesoBaseProliferacion() {
        //JOptionPane.showMessageDialog(new JFrame(), System.getProperty("java.class.path"));
        
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "No se encontro el controlador de la base de datos.");
        } finally {

            if (conectar()) {
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(crearTejido);
                    stmt.execute(crearCelula);
                    stmt.execute(crearLado);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "No se pudo ejecutar el ldd.");
                } finally {
                    desconectar();
                }
            }
        }
    }
    //</editor-fold>

    /**
     * hace la conexion con una base de datos.
     * @return retorna verdadero si hizo la conexion con exito
     */
    private boolean conectar() {
        try {
            conn = DriverManager.getConnection(cadenaConexionDDBB);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * Desconecta la base de datos.
     */
    private void desconectar() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
            conn = null;
        }
    }

    /**
     * Genera una tabla desde la base de datos a la que esta conectada.
     * @param rs
     * @return retorna un modelo segun el objeto ResultSet
     * @throws SQLException 
     */
    private DefaultTableModel generarTabla(ResultSet rs) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSetMetaData rsMd = rs.getMetaData();
        int cantidadColumnas = rsMd.getColumnCount();
        //Establecer como cabezeras el nombre de las columnas
        for (int i = 1; i <= cantidadColumnas; i++) {
            modelo.addColumn(rsMd.getColumnLabel(i));
        }
        //Creando las filas para el JTable
        while (rs.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            modelo.addRow(fila);
        }
        return modelo;
    }
    /**
     * ejecuta una sentencia sql
     * @param sql
     * @return 
     */
    public Object ejecutar(String sql){
        try {
            // Hacer la conexion con la base de datos
            if (this.conectar()) {
                try (Statement stmt = conn.createStatement()) {
                    if (stmt.execute(sql)) {
                        return generarTabla(stmt.getResultSet());
                    } else {
                        throw new SQLException("no se puede ejecutar sql");
                    }
                } catch (SQLException e) {
                    throw e;
                }
            } else {
                throw new SQLException("NO SE PUDO ABRIR BASE DE DATOS");
            }
        } catch (SQLException se) {
            return se;
        }
    }

    /**
     * Almacena un tejido en la base de datos.
     * @param tejido 
     */
    public void guardarTejido(Tejido<Celula> tejido) {
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

    public String getSentencia(String tabla) {
        switch(tabla){
            case "Modelo.Tejido":
                return "SELECT * FROM TEJIDO";
            case "Modelo.Celula":
        return "SELECT * FROM CELULA";
            case "Modelo.Arco":
        return "SELECT * FROM LADO";
        }
        return "";
    }
    
}
